package com.dape.upms.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.upms.dao.model.UpmsSystem;
import com.dape.upms.dao.model.UpmsSystemExample;

/**
* UpmsSystemService接口
* ncoffice on 2017/3/20.
*/
public interface UpmsSystemService extends BaseService<UpmsSystem, UpmsSystemExample> {

    /**
     * 根据name获取UpmsSystem
     * @param name
     * @return
     */
    UpmsSystem selectUpmsSystemByName(String name);

}