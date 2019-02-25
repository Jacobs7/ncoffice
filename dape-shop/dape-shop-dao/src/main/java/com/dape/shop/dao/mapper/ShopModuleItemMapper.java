package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopModuleItem;
import com.dape.shop.dao.model.ShopModuleItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopModuleItemMapper {
    long countByExample(ShopModuleItemExample example);

    int deleteByExample(ShopModuleItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopModuleItem record);

    int insertSelective(ShopModuleItem record);

    List<ShopModuleItem> selectByExample(ShopModuleItemExample example);

    ShopModuleItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopModuleItem record, @Param("example") ShopModuleItemExample example);

    int updateByExample(@Param("record") ShopModuleItem record, @Param("example") ShopModuleItemExample example);

    int updateByPrimaryKeySelective(ShopModuleItem record);

    int updateByPrimaryKey(ShopModuleItem record);
}