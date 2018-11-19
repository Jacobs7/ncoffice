package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopModule;
import com.dape.shop.dao.model.ShopModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopModuleMapper {
    long countByExample(ShopModuleExample example);

    int deleteByExample(ShopModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopModule record);

    int insertSelective(ShopModule record);

    List<ShopModule> selectByExample(ShopModuleExample example);

    ShopModule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopModule record, @Param("example") ShopModuleExample example);

    int updateByExample(@Param("record") ShopModule record, @Param("example") ShopModuleExample example);

    int updateByPrimaryKeySelective(ShopModule record);

    int updateByPrimaryKey(ShopModule record);
}