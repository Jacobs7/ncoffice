package com.dape.pay.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by ZhangShuzheng on 2017/3/29.
 */
public class DapePayRpcServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DapePayRpcServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info(">>>>> dape-pay-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		LOGGER.info(">>>>> dape-pay-rpc-service 启动完成 <<<<<");
	}

}
