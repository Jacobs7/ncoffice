package com.dape.datax.rpc.api;

import com.aliyun.oss.OSSClient;

import com.dape.datax.dao.model.DataxApplySource;
import com.mongodb.MongoClient;
import net.spy.memcached.MemcachedClient;
import org.apache.hadoop.fs.FileSystem;

import java.sql.Connection;

public interface ConnectionInterService {

    Connection getMySqlConnection(DataxApplySource applySource);

    Connection getSqlServerConnection(DataxApplySource applySource);

    Connection getOracleConnection(DataxApplySource applySource);

    Connection getDrdsConnection(DataxApplySource applySource);

    MongoClient getMongoDBConnection(DataxApplySource applySource);

    FileSystem getHDFSConnection(DataxApplySource applySource);

    MemcachedClient getOCSConnection(DataxApplySource applySource);

    OSSClient getOSSConnection(DataxApplySource applySource);

    Connection  getPostgresConnection(DataxApplySource applySource);

    void getRdbmsConnection(DataxApplySource applySource);

    void getStreamConnection(DataxApplySource applySource);

    void getTxtConnection(DataxApplySource applySource);

    void getFtpConnection(DataxApplySource applySource);


}
