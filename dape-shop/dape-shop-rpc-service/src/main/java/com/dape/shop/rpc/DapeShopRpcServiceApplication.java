package com.dape.shop.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by TengYong on 2018/11/17.
 */
public class DapeShopRpcServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DapeShopRpcServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info(">>>>> dape-shop-rpc-service 正在启动 <<<<<");
        new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        LOGGER.info(">>>>> dape-shop-rpc-service 启动完成 <<<<<");
    }
}
