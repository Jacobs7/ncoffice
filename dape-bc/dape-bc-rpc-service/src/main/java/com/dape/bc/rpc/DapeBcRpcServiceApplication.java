package com.dape.bc.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by TengYong on 2018/11/17.
 */
public class DapeBcRpcServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DapeBcRpcServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info(">>>>> dape-bc-rpc-service 正在启动 <<<<<");
        new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        LOGGER.info(">>>>> dape-bc-rpc-service 启动完成 <<<<<");
    }
}
