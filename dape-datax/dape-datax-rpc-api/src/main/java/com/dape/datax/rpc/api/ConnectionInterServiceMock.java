package com.dape.datax.rpc.api;

import com.aliyun.oss.OSSClient;
import com.dape.common.base.BaseServiceMock;
import com.dape.datax.dao.mapper.DataxApplySourceMapper;
import com.dape.datax.dao.model.DataxApplySource;
import com.dape.datax.dao.model.DataxApplySourceExample;
import com.dape.datax.rpc.api.ConnectionInterService;
import com.mongodb.MongoClient;
import net.spy.memcached.MemcachedClient;
import org.apache.hadoop.fs.FileSystem;

import java.sql.Connection;

public class ConnectionInterServiceMock extends BaseServiceMock<DataxApplySourceMapper, DataxApplySource, DataxApplySourceExample> implements ConnectionInterService{

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
