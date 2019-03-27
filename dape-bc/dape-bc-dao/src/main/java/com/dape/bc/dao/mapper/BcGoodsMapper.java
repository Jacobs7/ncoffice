package com.dape.bc.dao.mapper;

import com.dape.bc.dao.model.BcGoods;
import com.dape.bc.dao.model.BcGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcGoodsMapper {
    long countByExample(BcGoodsExample example);

    int deleteByExample(BcGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcGoods record);

    int insertSelective(BcGoods record);

    List<BcGoods> selectByExample(BcGoodsExample example);

    BcGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcGoods record, @Param("example") BcGoodsExample example);

    int updateByExample(@Param("record") BcGoods record, @Param("example") BcGoodsExample example);

    int updateByPrimaryKeySelective(BcGoods record);

    int updateByPrimaryKey(BcGoods record);
}