package com.dape.datax.dao.mapper;

import com.dape.datax.dao.model.DataxApplySource;
import com.dape.datax.dao.model.DataxApplySourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataxApplySourceMapper {
    long countByExample(DataxApplySourceExample example);

    int deleteByExample(DataxApplySourceExample example);

    int insert(DataxApplySource record);

    int insertSelective(DataxApplySource record);

    List<DataxApplySource> selectByExample(DataxApplySourceExample example);

    int updateByExampleSelective(@Param("record") DataxApplySource record, @Param("example") DataxApplySourceExample example);

    int updateByExample(@Param("record") DataxApplySource record, @Param("example") DataxApplySourceExample example);
}