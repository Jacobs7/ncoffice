package com.dape.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.dape.common.base.BaseService;
import com.dape.upms.dao.model.UpmsRolePermission;
import com.dape.upms.dao.model.UpmsRolePermissionExample;

/**
* UpmsRolePermissionService接口
* ncoffice on 2017/3/20.
*/
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {

    /**
     * 角色权限
     * @param datas 权限数据
     * @param id 角色id
     * @return
     */
    int rolePermission(JSONArray datas, int id);

}