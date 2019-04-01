package com.dape.bc.dao.mapper;

import com.dape.bc.dao.model.BcPayOrderRefund;
import com.dape.bc.dao.model.BcPayOrderRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcPayOrderRefundMapper {
    long countByExample(BcPayOrderRefundExample example);

    int deleteByExample(BcPayOrderRefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcPayOrderRefund record);

    int insertSelective(BcPayOrderRefund record);

    List<BcPayOrderRefund> selectByExample(BcPayOrderRefundExample example);

    BcPayOrderRefund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcPayOrderRefund record, @Param("example") BcPayOrderRefundExample example);

    int updateByExample(@Param("record") BcPayOrderRefund record, @Param("example") BcPayOrderRefundExample example);

    int updateByPrimaryKeySelective(BcPayOrderRefund record);

    int updateByPrimaryKey(BcPayOrderRefund record);
}