
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 陪玩人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/peiwanrenyuan")
public class PeiwanrenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(PeiwanrenyuanController.class);

    @Autowired
    private PeiwanrenyuanService peiwanrenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("陪玩人员".equals(role))
            params.put("peiwanrenyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = peiwanrenyuanService.queryPage(params);

        //字典表数据转换
        List<PeiwanrenyuanView> list =(List<PeiwanrenyuanView>)page.getList();
        for(PeiwanrenyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PeiwanrenyuanEntity peiwanrenyuan = peiwanrenyuanService.selectById(id);
        if(peiwanrenyuan !=null){
            //entity转view
            PeiwanrenyuanView view = new PeiwanrenyuanView();
            BeanUtils.copyProperties( peiwanrenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PeiwanrenyuanEntity peiwanrenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,peiwanrenyuan:{}",this.getClass().getName(),peiwanrenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<PeiwanrenyuanEntity> queryWrapper = new EntityWrapper<PeiwanrenyuanEntity>()
            .eq("username", peiwanrenyuan.getUsername())
            .or()
            .eq("peiwanrenyuan_phone", peiwanrenyuan.getPeiwanrenyuanPhone())
            .or()
            .eq("peiwanrenyuan_id_number", peiwanrenyuan.getPeiwanrenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeiwanrenyuanEntity peiwanrenyuanEntity = peiwanrenyuanService.selectOne(queryWrapper);
        if(peiwanrenyuanEntity==null){
            peiwanrenyuan.setCreateTime(new Date());
            peiwanrenyuan.setPassword("123456");
            peiwanrenyuanService.insert(peiwanrenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者陪玩人员手机号或者陪玩人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeiwanrenyuanEntity peiwanrenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,peiwanrenyuan:{}",this.getClass().getName(),peiwanrenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<PeiwanrenyuanEntity> queryWrapper = new EntityWrapper<PeiwanrenyuanEntity>()
            .notIn("id",peiwanrenyuan.getId())
            .andNew()
            .eq("username", peiwanrenyuan.getUsername())
            .or()
            .eq("peiwanrenyuan_phone", peiwanrenyuan.getPeiwanrenyuanPhone())
            .or()
            .eq("peiwanrenyuan_id_number", peiwanrenyuan.getPeiwanrenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeiwanrenyuanEntity peiwanrenyuanEntity = peiwanrenyuanService.selectOne(queryWrapper);
        if("".equals(peiwanrenyuan.getPeiwanrenyuanPhoto()) || "null".equals(peiwanrenyuan.getPeiwanrenyuanPhoto())){
                peiwanrenyuan.setPeiwanrenyuanPhoto(null);
        }
        if(peiwanrenyuanEntity==null){
            peiwanrenyuanService.updateById(peiwanrenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者陪玩人员手机号或者陪玩人员身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        peiwanrenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PeiwanrenyuanEntity> peiwanrenyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PeiwanrenyuanEntity peiwanrenyuanEntity = new PeiwanrenyuanEntity();
//                            peiwanrenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //peiwanrenyuanEntity.setPassword("123456");//密码
//                            peiwanrenyuanEntity.setPeiwanrenyuanUuidMumber(data.get(0));                    //陪玩人员编号 要改的
//                            peiwanrenyuanEntity.setPeiwanrenyuanName(data.get(0));                    //陪玩人员姓名 要改的
//                            peiwanrenyuanEntity.setPeiwanrenyuanPhone(data.get(0));                    //陪玩人员手机号 要改的
//                            peiwanrenyuanEntity.setPeiwanrenyuanIdNumber(data.get(0));                    //陪玩人员身份证号 要改的
//                            peiwanrenyuanEntity.setPeiwanrenyuanPhoto("");//详情和图片
//                            peiwanrenyuanEntity.setPeiwanrenyuanJiage(data.get(0));                    //价格/小时 要改的
//                            peiwanrenyuanEntity.setPeiwanrenyuanShanchang(data.get(0));                    //擅长游戏 要改的
//                            peiwanrenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            peiwanrenyuanEntity.setPeiwanrenyuanContent("");//详情和图片
//                            peiwanrenyuanEntity.setCreateTime(date);//时间
                            peiwanrenyuanList.add(peiwanrenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //陪玩人员手机号
                                if(seachFields.containsKey("peiwanrenyuanPhone")){
                                    List<String> peiwanrenyuanPhone = seachFields.get("peiwanrenyuanPhone");
                                    peiwanrenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> peiwanrenyuanPhone = new ArrayList<>();
                                    peiwanrenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("peiwanrenyuanPhone",peiwanrenyuanPhone);
                                }
                                //陪玩人员身份证号
                                if(seachFields.containsKey("peiwanrenyuanIdNumber")){
                                    List<String> peiwanrenyuanIdNumber = seachFields.get("peiwanrenyuanIdNumber");
                                    peiwanrenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> peiwanrenyuanIdNumber = new ArrayList<>();
                                    peiwanrenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("peiwanrenyuanIdNumber",peiwanrenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<PeiwanrenyuanEntity> peiwanrenyuanEntities_username = peiwanrenyuanService.selectList(new EntityWrapper<PeiwanrenyuanEntity>().in("username", seachFields.get("username")));
                        if(peiwanrenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeiwanrenyuanEntity s:peiwanrenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //陪玩人员手机号
                        List<PeiwanrenyuanEntity> peiwanrenyuanEntities_peiwanrenyuanPhone = peiwanrenyuanService.selectList(new EntityWrapper<PeiwanrenyuanEntity>().in("peiwanrenyuan_phone", seachFields.get("peiwanrenyuanPhone")));
                        if(peiwanrenyuanEntities_peiwanrenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeiwanrenyuanEntity s:peiwanrenyuanEntities_peiwanrenyuanPhone){
                                repeatFields.add(s.getPeiwanrenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [陪玩人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //陪玩人员身份证号
                        List<PeiwanrenyuanEntity> peiwanrenyuanEntities_peiwanrenyuanIdNumber = peiwanrenyuanService.selectList(new EntityWrapper<PeiwanrenyuanEntity>().in("peiwanrenyuan_id_number", seachFields.get("peiwanrenyuanIdNumber")));
                        if(peiwanrenyuanEntities_peiwanrenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeiwanrenyuanEntity s:peiwanrenyuanEntities_peiwanrenyuanIdNumber){
                                repeatFields.add(s.getPeiwanrenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [陪玩人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        peiwanrenyuanService.insertBatch(peiwanrenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        PeiwanrenyuanEntity peiwanrenyuan = peiwanrenyuanService.selectOne(new EntityWrapper<PeiwanrenyuanEntity>().eq("username", username));
        if(peiwanrenyuan==null || !peiwanrenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(peiwanrenyuan.getId(),username, "peiwanrenyuan", "陪玩人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","陪玩人员");
        r.put("username",peiwanrenyuan.getPeiwanrenyuanName());
        r.put("tableName","peiwanrenyuan");
        r.put("userId",peiwanrenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody PeiwanrenyuanEntity peiwanrenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<PeiwanrenyuanEntity> queryWrapper = new EntityWrapper<PeiwanrenyuanEntity>()
            .eq("username", peiwanrenyuan.getUsername())
            .or()
            .eq("peiwanrenyuan_phone", peiwanrenyuan.getPeiwanrenyuanPhone())
            .or()
            .eq("peiwanrenyuan_id_number", peiwanrenyuan.getPeiwanrenyuanIdNumber())
            ;
        PeiwanrenyuanEntity peiwanrenyuanEntity = peiwanrenyuanService.selectOne(queryWrapper);
        if(peiwanrenyuanEntity != null)
            return R.error("账户或者陪玩人员手机号或者陪玩人员身份证号已经被使用");
        peiwanrenyuan.setCreateTime(new Date());
        peiwanrenyuanService.insert(peiwanrenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        PeiwanrenyuanEntity peiwanrenyuan = new PeiwanrenyuanEntity();
        peiwanrenyuan.setPassword("123456");
        peiwanrenyuan.setId(id);
        peiwanrenyuanService.updateById(peiwanrenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        PeiwanrenyuanEntity peiwanrenyuan = peiwanrenyuanService.selectOne(new EntityWrapper<PeiwanrenyuanEntity>().eq("username", username));
        if(peiwanrenyuan!=null){
            peiwanrenyuan.setPassword("123456");
            boolean b = peiwanrenyuanService.updateById(peiwanrenyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrPeiwanrenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        PeiwanrenyuanEntity peiwanrenyuan = peiwanrenyuanService.selectById(id);
        if(peiwanrenyuan !=null){
            //entity转view
            PeiwanrenyuanView view = new PeiwanrenyuanView();
            BeanUtils.copyProperties( peiwanrenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = peiwanrenyuanService.queryPage(params);

        //字典表数据转换
        List<PeiwanrenyuanView> list =(List<PeiwanrenyuanView>)page.getList();
        for(PeiwanrenyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PeiwanrenyuanEntity peiwanrenyuan = peiwanrenyuanService.selectById(id);
            if(peiwanrenyuan !=null){


                //entity转view
                PeiwanrenyuanView view = new PeiwanrenyuanView();
                BeanUtils.copyProperties( peiwanrenyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody PeiwanrenyuanEntity peiwanrenyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,peiwanrenyuan:{}",this.getClass().getName(),peiwanrenyuan.toString());
        Wrapper<PeiwanrenyuanEntity> queryWrapper = new EntityWrapper<PeiwanrenyuanEntity>()
            .eq("username", peiwanrenyuan.getUsername())
            .or()
            .eq("peiwanrenyuan_phone", peiwanrenyuan.getPeiwanrenyuanPhone())
            .or()
            .eq("peiwanrenyuan_id_number", peiwanrenyuan.getPeiwanrenyuanIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeiwanrenyuanEntity peiwanrenyuanEntity = peiwanrenyuanService.selectOne(queryWrapper);
        if(peiwanrenyuanEntity==null){
            peiwanrenyuan.setCreateTime(new Date());
        peiwanrenyuan.setPassword("123456");
        peiwanrenyuanService.insert(peiwanrenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者陪玩人员手机号或者陪玩人员身份证号已经被使用");
        }
    }


}
