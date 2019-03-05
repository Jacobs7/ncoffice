package com.dape.datax.dao.mapper;

import com.dape.datax.dao.model.DataxTask;
import com.dape.datax.dao.model.DataxTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataxTaskMapper {
    long countByExample(DataxTaskExample example);

    int deleteByExample(DataxTaskExample example);

    int insert(DataxTask record);

    int insertSelective(DataxTask record);

    List<DataxTask> selectByExample(DataxTaskExample example);

    int updateByExampleSelective(@Param("record") DataxTask record, @Param("example") DataxTaskExample example);

    int updateByExample(@Param("record") DataxTask record, @Param("example") DataxTaskExample example);
}