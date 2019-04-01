package com.dape.bc.dao.mapper;

import com.dape.bc.dao.model.BcPayOrder;
import com.dape.bc.dao.model.BcPayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcPayOrderMapper {
    long countByExample(BcPayOrderExample example);

    int deleteByExample(BcPayOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcPayOrder record);

    int insertSelective(BcPayOrder record);

    List<BcPayOrder> selectByExample(BcPayOrderExample example);

    BcPayOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcPayOrder record, @Param("example") BcPayOrderExample example);

    int updateByExample(@Param("record") BcPayOrder record, @Param("example") BcPayOrderExample example);

    int updateByPrimaryKeySelective(BcPayOrder record);

    int updateByPrimaryKey(BcPayOrder record);
}