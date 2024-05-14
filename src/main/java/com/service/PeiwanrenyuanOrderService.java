package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeiwanrenyuanOrderEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 陪玩人员订单 服务类
 */
public interface PeiwanrenyuanOrderService extends IService<PeiwanrenyuanOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}