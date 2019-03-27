package com.dape.bc.dao.mapper;

import com.dape.bc.dao.model.BcMenu;
import com.dape.bc.dao.model.BcMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcMenuMapper {
    long countByExample(BcMenuExample example);

    int deleteByExample(BcMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcMenu record);

    int insertSelective(BcMenu record);

    List<BcMenu> selectByExample(BcMenuExample example);

    BcMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcMenu record, @Param("example") BcMenuExample example);

    int updateByExample(@Param("record") BcMenu record, @Param("example") BcMenuExample example);

    int updateByPrimaryKeySelective(BcMenu record);

    int updateByPrimaryKey(BcMenu record);
}