package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopSms;
import com.dape.shop.dao.model.ShopSmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopSmsMapper {
    long countByExample(ShopSmsExample example);

    int deleteByExample(ShopSmsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopSms record);

    int insertSelective(ShopSms record);

    List<ShopSms> selectByExample(ShopSmsExample example);

    ShopSms selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopSms record, @Param("example") ShopSmsExample example);

    int updateByExample(@Param("record") ShopSms record, @Param("example") ShopSmsExample example);

    int updateByPrimaryKeySelective(ShopSms record);

    int updateByPrimaryKey(ShopSms record);
}