package com.dape.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 启动解压zhengAdmin-x.x.x.jar到resources目录
 * ncoffice on 2016/12/18.
 */
public class DapeLTEUtil implements InitializingBean, ServletContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(DapeLTEUtil.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("===== 开始解压dape-admin =====");
        String version = PropertiesFileUtil.getInstance("dape-lte-client").get("dape.admin.version");
        LOGGER.info("dape-admin.jar 版本: {}", version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/dape-lte-" + version + ".jar");
        LOGGER.info("dape-admin.jar 包路径: {}", jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/dape-lte";

        LOGGER.info("dape-admin.jar 解压到: {}", resources);
        JarUtil.decompress(jarPath, resources);
        LOGGER.info("===== 解压dape-admin完成 =====");
    }

}
