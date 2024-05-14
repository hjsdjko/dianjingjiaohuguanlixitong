package com.dao;

import com.entity.PeiwanrenyuanOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeiwanrenyuanOrderView;

/**
 * 陪玩人员订单 Dao 接口
 *
 * @author 
 */
public interface PeiwanrenyuanOrderDao extends BaseMapper<PeiwanrenyuanOrderEntity> {

   List<PeiwanrenyuanOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
