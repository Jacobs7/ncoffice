package com.dape.datax.rpc.api;

import com.aliyun.oss.OSSClient;
import com.dape.common.base.BaseServiceMock;
import com.dape.datax.common.constant.DataxResult;
import com.dape.datax.dao.mapper.DataxApplySourceMapper;
import com.dape.datax.dao.model.DataxApplySource;
import com.dape.datax.dao.model.DataxApplySourceExample;
import com.dape.datax.dao.model.DataxSourceType;
import com.mongodb.MongoClient;
import net.spy.memcached.MemcachedClient;
import org.apache.hadoop.fs.FileSystem;

import java.sql.Connection;

public class DataxGetAllConnectionServiceMock  implements DataxGetAllConnectionService {


    @Override
    public DataxResult getMySqlConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getSqlServerConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getOracleConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getDrdsConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getMongoDBConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getHDFSConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getOCSConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getOSSConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getPostgresConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getRdbmsConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getStreamConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getTxtConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }

    @Override
    public DataxResult getFtpConnection(DataxApplySource applySource, DataxSourceType dataxSourceType) {
        return null;
    }
}
