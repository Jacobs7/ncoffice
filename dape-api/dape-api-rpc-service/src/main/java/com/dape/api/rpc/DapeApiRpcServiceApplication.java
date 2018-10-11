package com.dape.api.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by shuzheng on 2017/2/19.
 */
public class DapeApiRpcServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DapeApiRpcServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info(">>>>> zheng-api-rpc-service 正在启动 <<<<<");
        new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        LOGGER.info(">>>>> zheng-api-rpc-service 启动完成 <<<<<");
    }
}
