package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopMenu;
import com.dape.shop.dao.model.ShopMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMenuMapper {
    long countByExample(ShopMenuExample example);

    int deleteByExample(ShopMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopMenu record);

    int insertSelective(ShopMenu record);

    List<ShopMenu> selectByExample(ShopMenuExample example);

    ShopMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopMenu record, @Param("example") ShopMenuExample example);

    int updateByExample(@Param("record") ShopMenu record, @Param("example") ShopMenuExample example);

    int updateByPrimaryKeySelective(ShopMenu record);

    int updateByPrimaryKey(ShopMenu record);
}