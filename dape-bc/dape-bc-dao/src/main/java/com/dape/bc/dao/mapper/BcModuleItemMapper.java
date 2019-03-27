package com.dape.bc.dao.mapper;

import com.dape.bc.dao.model.BcModuleItem;
import com.dape.bc.dao.model.BcModuleItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcModuleItemMapper {
    long countByExample(BcModuleItemExample example);

    int deleteByExample(BcModuleItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BcModuleItem record);

    int insertSelective(BcModuleItem record);

    List<BcModuleItem> selectByExample(BcModuleItemExample example);

    BcModuleItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BcModuleItem record, @Param("example") BcModuleItemExample example);

    int updateByExample(@Param("record") BcModuleItem record, @Param("example") BcModuleItemExample example);

    int updateByPrimaryKeySelective(BcModuleItem record);

    int updateByPrimaryKey(BcModuleItem record);
}