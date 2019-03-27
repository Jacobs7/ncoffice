package com.dape.bc.dao.mapper;

import com.dape.bc.dao.model.BcModule;
import com.dape.bc.dao.model.BcModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcModuleMapper {
    long countByExample(BcModuleExample example);

    int deleteByExample(BcModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcModule record);

    int insertSelective(BcModule record);

    List<BcModule> selectByExample(BcModuleExample example);

    BcModule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcModule record, @Param("example") BcModuleExample example);

    int updateByExample(@Param("record") BcModule record, @Param("example") BcModuleExample example);

    int updateByPrimaryKeySelective(BcModule record);

    int updateByPrimaryKey(BcModule record);
}