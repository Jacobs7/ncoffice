package com.dape.upms.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.upms.dao.model.UpmsUserRole;
import com.dape.upms.dao.model.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* ncoffice on 2017/3/20.
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {

    /**
     * 用户角色
     * @param roleIds 角色ids
     * @param id 用户id
     * @return
     */
    int role(String[] roleIds, int id);

}