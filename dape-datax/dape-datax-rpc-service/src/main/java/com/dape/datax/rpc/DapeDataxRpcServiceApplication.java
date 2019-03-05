package com.dape.datax.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by dape on 2017/2/3.
 */
public class DapeDataxRpcServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DapeDataxRpcServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info(">>>>> dape-datax-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		LOGGER.info(">>>>> dape-datax-rpc-service 启动完成 <<<<<");
	}

}
