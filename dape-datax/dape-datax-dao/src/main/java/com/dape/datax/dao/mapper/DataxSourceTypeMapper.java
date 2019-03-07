package com.dape.datax.dao.mapper;

import com.dape.datax.dao.model.DataxSourceType;
import com.dape.datax.dao.model.DataxSourceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataxSourceTypeMapper {
    long countByExample(DataxSourceTypeExample example);

    int deleteByExample(DataxSourceTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataxSourceType record);

    int insertSelective(DataxSourceType record);

    List<DataxSourceType> selectByExample(DataxSourceTypeExample example);

    DataxSourceType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataxSourceType record, @Param("example") DataxSourceTypeExample example);

    int updateByExample(@Param("record") DataxSourceType record, @Param("example") DataxSourceTypeExample example);

    int updateByPrimaryKeySelective(DataxSourceType record);

    int updateByPrimaryKey(DataxSourceType record);
}