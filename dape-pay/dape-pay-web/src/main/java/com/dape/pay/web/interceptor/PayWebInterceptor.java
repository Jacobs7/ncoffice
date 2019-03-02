package com.dape.pay.web.interceptor;

import com.dape.common.util.PropertiesFileUtil;
import com.dape.common.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayWebInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayWebInterceptor.class);

    private final static String DAPE_UPMS_SERVER_SESSION_ID = "dape-upms-server-session-id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String hasCode = RedisUtil.get(DAPE_UPMS_SERVER_SESSION_ID + "_" + request.getSession().getId().toString());

        String url = request.getRequestURI();
        if(url.startsWith("/login")){// 排除登录相关请求
            System.out.println("登录相关请求");
            if(StringUtils.isNotBlank(hasCode)){// 如果登录重定向到首页
                response.sendRedirect("/");// 重定向到登录页
            }
        }else{// 非登录相关，验证登录状态
            System.out.println("业务相关请求");
            if(StringUtils.isBlank(hasCode)){// 未登录重定向到登录页
                response.sendRedirect("/login");// 重定向到登录页
            }
        }

        // 过滤ajax
        if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            return true;
        }



        // zheng-ui静态资源配置信息
        String appName = PropertiesFileUtil.getInstance().get("app.name");
        String uiPath = PropertiesFileUtil.getInstance().get("dape.ui.path");
        request.setAttribute("appName", appName);
        request.setAttribute("uiPath", uiPath);
        // 菜单
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
