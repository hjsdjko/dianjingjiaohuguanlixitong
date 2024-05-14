package com.entity.model;

import com.entity.PeiwanrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 陪玩人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeiwanrenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 陪玩人员编号
     */
    private String peiwanrenyuanUuidMumber;


    /**
     * 陪玩人员姓名
     */
    private String peiwanrenyuanName;


    /**
     * 陪玩人员手机号
     */
    private String peiwanrenyuanPhone;


    /**
     * 陪玩人员身份证号
     */
    private String peiwanrenyuanIdNumber;


    /**
     * 陪玩人员头像
     */
    private String peiwanrenyuanPhoto;


    /**
     * 价格/小时
     */
    private Double peiwanrenyuanJiage;


    /**
     * 擅长游戏
     */
    private String peiwanrenyuanShanchang;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 陪玩人员详细介绍
     */
    private String peiwanrenyuanContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：陪玩人员编号
	 */
    public String getPeiwanrenyuanUuidMumber() {
        return peiwanrenyuanUuidMumber;
    }


    /**
	 * 设置：陪玩人员编号
	 */
    public void setPeiwanrenyuanUuidMumber(String peiwanrenyuanUuidMumber) {
        this.peiwanrenyuanUuidMumber = peiwanrenyuanUuidMumber;
    }
    /**
	 * 获取：陪玩人员姓名
	 */
    public String getPeiwanrenyuanName() {
        return peiwanrenyuanName;
    }


    /**
	 * 设置：陪玩人员姓名
	 */
    public void setPeiwanrenyuanName(String peiwanrenyuanName) {
        this.peiwanrenyuanName = peiwanrenyuanName;
    }
    /**
	 * 获取：陪玩人员手机号
	 */
    public String getPeiwanrenyuanPhone() {
        return peiwanrenyuanPhone;
    }


    /**
	 * 设置：陪玩人员手机号
	 */
    public void setPeiwanrenyuanPhone(String peiwanrenyuanPhone) {
        this.peiwanrenyuanPhone = peiwanrenyuanPhone;
    }
    /**
	 * 获取：陪玩人员身份证号
	 */
    public String getPeiwanrenyuanIdNumber() {
        return peiwanrenyuanIdNumber;
    }


    /**
	 * 设置：陪玩人员身份证号
	 */
    public void setPeiwanrenyuanIdNumber(String peiwanrenyuanIdNumber) {
        this.peiwanrenyuanIdNumber = peiwanrenyuanIdNumber;
    }
    /**
	 * 获取：陪玩人员头像
	 */
    public String getPeiwanrenyuanPhoto() {
        return peiwanrenyuanPhoto;
    }


    /**
	 * 设置：陪玩人员头像
	 */
    public void setPeiwanrenyuanPhoto(String peiwanrenyuanPhoto) {
        this.peiwanrenyuanPhoto = peiwanrenyuanPhoto;
    }
    /**
	 * 获取：价格/小时
	 */
    public Double getPeiwanrenyuanJiage() {
        return peiwanrenyuanJiage;
    }


    /**
	 * 设置：价格/小时
	 */
    public void setPeiwanrenyuanJiage(Double peiwanrenyuanJiage) {
        this.peiwanrenyuanJiage = peiwanrenyuanJiage;
    }
    /**
	 * 获取：擅长游戏
	 */
    public String getPeiwanrenyuanShanchang() {
        return peiwanrenyuanShanchang;
    }


    /**
	 * 设置：擅长游戏
	 */
    public void setPeiwanrenyuanShanchang(String peiwanrenyuanShanchang) {
        this.peiwanrenyuanShanchang = peiwanrenyuanShanchang;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：陪玩人员详细介绍
	 */
    public String getPeiwanrenyuanContent() {
        return peiwanrenyuanContent;
    }


    /**
	 * 设置：陪玩人员详细介绍
	 */
    public void setPeiwanrenyuanContent(String peiwanrenyuanContent) {
        this.peiwanrenyuanContent = peiwanrenyuanContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
