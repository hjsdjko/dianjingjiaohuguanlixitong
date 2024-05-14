package com.dao;

import com.entity.PeiwanrenyuanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeiwanrenyuanLiuyanView;

/**
 * 陪玩人员留言 Dao 接口
 *
 * @author 
 */
public interface PeiwanrenyuanLiuyanDao extends BaseMapper<PeiwanrenyuanLiuyanEntity> {

   List<PeiwanrenyuanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
