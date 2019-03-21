package com.dape.datax.rpc.api;

import com.aliyun.oss.OSSClient;
import com.dape.common.base.BaseService;
import com.dape.datax.common.constant.DataxResult;
import com.dape.datax.dao.model.DataxApplySource;
import com.dape.datax.dao.model.DataxApplySourceExample;
import com.dape.datax.dao.model.DataxSourceType;
import com.mongodb.MongoClient;
import net.spy.memcached.MemcachedClient;
import org.apache.hadoop.fs.FileSystem;

import java.sql.Connection;

public interface DataxGetAllConnectionService {

    DataxResult getMySqlConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getSqlServerConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getOracleConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getDrdsConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getMongoDBConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getHDFSConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getOCSConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getOSSConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult  getPostgresConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getRdbmsConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getStreamConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getTxtConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

    DataxResult getFtpConnection(DataxApplySource applySource, DataxSourceType dataxSourceType);

}
