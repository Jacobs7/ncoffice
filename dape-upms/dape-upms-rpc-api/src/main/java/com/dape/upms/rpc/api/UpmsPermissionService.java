package com.dape.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.dape.common.base.BaseService;
import com.dape.upms.dao.model.UpmsPermission;
import com.dape.upms.dao.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* ncoffice on 2017/3/20.
*/
public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {

    JSONArray getTreeByRoleId(Integer roleId);

    JSONArray getTreeByUserId(Integer usereId, Byte type);

}