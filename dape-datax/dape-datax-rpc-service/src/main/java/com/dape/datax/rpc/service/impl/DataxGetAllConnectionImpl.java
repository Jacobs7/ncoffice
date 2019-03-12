package com.dape.datax.rpc.service.impl;

import com.aliyun.oss.OSSClient;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.datax.dao.mapper.DataxApplySourceMapper;
import com.dape.datax.dao.model.DataxApplySource;
import com.dape.datax.dao.model.DataxApplySourceExample;
import com.dape.datax.rpc.api.ConnectionInterService;
import com.mongodb.MongoClient;
import net.spy.memcached.MemcachedClient;
import org.apache.hadoop.fs.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;


@Service
@Transactional
public class DataxGetAllConnectionImpl implements ConnectionInterService{


    private static final Logger LOGGER = LoggerFactory.getLogger(DataxSourceTypeServiceImpl.class);



    @Override
    public Connection getMySqlConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public Connection getSqlServerConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public Connection getOracleConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public Connection getDrdsConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public MongoClient getMongoDBConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public FileSystem getHDFSConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public MemcachedClient getOCSConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public OSSClient getOSSConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public Connection getPostgresConnection(DataxApplySource applySource) {
        return null;
    }

    @Override
    public void getRdbmsConnection(DataxApplySource applySource) {

    }

    @Override
    public void getStreamConnection(DataxApplySource applySource) {

    }

    @Override
    public void getTxtConnection(DataxApplySource applySource) {

    }

    @Override
    public void getFtpConnection(DataxApplySource applySource) {

    }
}
