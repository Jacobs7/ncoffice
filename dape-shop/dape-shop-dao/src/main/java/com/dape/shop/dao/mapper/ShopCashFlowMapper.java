package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopCashFlow;
import com.dape.shop.dao.model.ShopCashFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCashFlowMapper {
    long countByExample(ShopCashFlowExample example);

    int deleteByExample(ShopCashFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopCashFlow record);

    int insertSelective(ShopCashFlow record);

    List<ShopCashFlow> selectByExample(ShopCashFlowExample example);

    ShopCashFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopCashFlow record, @Param("example") ShopCashFlowExample example);

    int updateByExample(@Param("record") ShopCashFlow record, @Param("example") ShopCashFlowExample example);

    int updateByPrimaryKeySelective(ShopCashFlow record);

    int updateByPrimaryKey(ShopCashFlow record);
}