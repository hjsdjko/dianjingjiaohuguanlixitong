package com.dao;

import com.entity.PeiwanrenyuanCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeiwanrenyuanCommentbackView;

/**
 * 陪玩人员评价 Dao 接口
 *
 * @author 
 */
public interface PeiwanrenyuanCommentbackDao extends BaseMapper<PeiwanrenyuanCommentbackEntity> {

   List<PeiwanrenyuanCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
