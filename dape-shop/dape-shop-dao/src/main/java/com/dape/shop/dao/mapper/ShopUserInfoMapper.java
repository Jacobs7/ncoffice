package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopUserInfo;
import com.dape.shop.dao.model.ShopUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopUserInfoMapper {
    long countByExample(ShopUserInfoExample example);

    int deleteByExample(ShopUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopUserInfo record);

    int insertSelective(ShopUserInfo record);

    List<ShopUserInfo> selectByExample(ShopUserInfoExample example);

    ShopUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopUserInfo record, @Param("example") ShopUserInfoExample example);

    int updateByExample(@Param("record") ShopUserInfo record, @Param("example") ShopUserInfoExample example);

    int updateByPrimaryKeySelective(ShopUserInfo record);

    int updateByPrimaryKey(ShopUserInfo record);
}