package com.dape.upms.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.upms.dao.model.UpmsUserOrganization;
import com.dape.upms.dao.model.UpmsUserOrganizationExample;

/**
* UpmsUserOrganizationService接口
* Created by shuzheng on 2017/3/20.
*/
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {

    /**
     * 用户组织
     * @param organizationIds 组织ids
     * @param id 用户id
     * @return
     */
    int organization(String[] organizationIds, int id);

}