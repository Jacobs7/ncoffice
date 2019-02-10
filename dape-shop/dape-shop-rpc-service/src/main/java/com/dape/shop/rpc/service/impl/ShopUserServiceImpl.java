package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopUserMapper;
import com.dape.shop.dao.mapper.UpmsUserMapper;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopUserService;
import com.dape.shop.rpc.mapper.ShopUserOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
* ShopUserService实现
* Created by dape on 2018/11/17.
*/
@Service
@Transactional
@BaseService
public class ShopUserServiceImpl extends BaseServiceImpl<ShopUserMapper, ShopUser, ShopUserExample> implements ShopUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopUserServiceImpl.class);

    @Autowired
    ShopUserMapper shopUserMapper;
    @Autowired
    ShopUserOrderMapper shopUserOrderMapper;
    @Autowired
    UpmsUserMapper upmsUserMapper;

    @Override
    public int listUserOrderCount(Map<String, Object> params) {
        return shopUserOrderMapper.listUserOrderCount(params);
    }

    @Override
    public List<ShopUserOrder> listUserOrder(Map<String, Object> params) {
        return shopUserOrderMapper.listUserOrder(params);
    }

    @Override
    public UpmsUser selectUpmsUserByUsername(String username) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andUsernameEqualTo(username);
        List<UpmsUser> upmsUsers = upmsUserMapper.selectByExample(upmsUserExample);
        if (null != upmsUsers && upmsUsers.size() > 0) {
            return upmsUsers.get(0);
        }
        return null;
    }

    @Override
    public UpmsUser selectUpmsUserByOpenid(String openid) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andOpenidEqualTo(openid);
        List<UpmsUser> upmsUsers = upmsUserMapper.selectByExample(upmsUserExample);
        if (null != upmsUsers && upmsUsers.size() > 0) {
            return upmsUsers.get(0);
        }
        return null;
    }

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andUsernameEqualTo(upmsUser.getUsername());
        long count = upmsUserMapper.countByExample(upmsUserExample);
        if (count > 0) {
            return null;
        }
        upmsUserMapper.insert(upmsUser);
        return upmsUser;
    }

    @Override
    public int countUpmsUser(String username){
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andUsernameEqualTo(username);
        return (int)upmsUserMapper.countByExample(upmsUserExample);
    }

    @Override
    public int updateByPrimaryKey(UpmsUser upmsUser){
        return upmsUserMapper.updateByPrimaryKey(upmsUser);
    }
}