package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopDetailImgUrl;
import com.dape.shop.dao.model.ShopDetailImgUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopDetailImgUrlMapper {
    long countByExample(ShopDetailImgUrlExample example);

    int deleteByExample(ShopDetailImgUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopDetailImgUrl record);

    int insertSelective(ShopDetailImgUrl record);

    List<ShopDetailImgUrl> selectByExample(ShopDetailImgUrlExample example);

    ShopDetailImgUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopDetailImgUrl record, @Param("example") ShopDetailImgUrlExample example);

    int updateByExample(@Param("record") ShopDetailImgUrl record, @Param("example") ShopDetailImgUrlExample example);

    int updateByPrimaryKeySelective(ShopDetailImgUrl record);

    int updateByPrimaryKey(ShopDetailImgUrl record);
}