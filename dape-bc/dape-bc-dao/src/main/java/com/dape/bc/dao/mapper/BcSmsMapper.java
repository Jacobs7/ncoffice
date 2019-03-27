package com.dape.bc.dao.mapper;

import com.dape.bc.dao.model.BcSms;
import com.dape.bc.dao.model.BcSmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcSmsMapper {
    long countByExample(BcSmsExample example);

    int deleteByExample(BcSmsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcSms record);

    int insertSelective(BcSms record);

    List<BcSms> selectByExample(BcSmsExample example);

    BcSms selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcSms record, @Param("example") BcSmsExample example);

    int updateByExample(@Param("record") BcSms record, @Param("example") BcSmsExample example);

    int updateByPrimaryKeySelective(BcSms record);

    int updateByPrimaryKey(BcSms record);
}