package com.dape.shop.dao.mapper;

import com.dape.shop.dao.model.ShopMaterialImport;
import com.dape.shop.dao.model.ShopMaterialImportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMaterialImportMapper {
    long countByExample(ShopMaterialImportExample example);

    int deleteByExample(ShopMaterialImportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopMaterialImport record);

    int insertSelective(ShopMaterialImport record);

    List<ShopMaterialImport> selectByExample(ShopMaterialImportExample example);

    ShopMaterialImport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopMaterialImport record, @Param("example") ShopMaterialImportExample example);

    int updateByExample(@Param("record") ShopMaterialImport record, @Param("example") ShopMaterialImportExample example);

    int updateByPrimaryKeySelective(ShopMaterialImport record);

    int updateByPrimaryKey(ShopMaterialImport record);
}