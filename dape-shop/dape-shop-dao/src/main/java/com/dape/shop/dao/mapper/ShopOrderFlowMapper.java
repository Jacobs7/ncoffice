package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopOrderFlow;
import com.dape.shop.dao.model.ShopOrderFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopOrderFlowMapper {
    long countByExample(ShopOrderFlowExample example);

    int deleteByExample(ShopOrderFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopOrderFlow record);

    int insertSelective(ShopOrderFlow record);

    List<ShopOrderFlow> selectByExample(ShopOrderFlowExample example);

    ShopOrderFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopOrderFlow record, @Param("example") ShopOrderFlowExample example);

    int updateByExample(@Param("record") ShopOrderFlow record, @Param("example") ShopOrderFlowExample example);

    int updateByPrimaryKeySelective(ShopOrderFlow record);

    int updateByPrimaryKey(ShopOrderFlow record);
}