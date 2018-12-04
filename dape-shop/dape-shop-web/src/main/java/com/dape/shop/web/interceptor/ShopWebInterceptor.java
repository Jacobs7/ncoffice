package com.dape.shop.web.interceptor;

import com.dape.common.util.PropertiesFileUtil;
import com.dape.common.util.RamdonUtil;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;
import com.dape.shop.rpc.api.ShopUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShopWebInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopWebInterceptor.class);

    public ShopUserService shopUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object o = request.getSession().getAttribute("openId");
        if(o == null){
            String openId = "test_open_id";// 上线后要改为从微信获取
            if(openId == null){
                return false;
            }
            if(shopUserService == null){// 解决拦截器不能注入service问题
                BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
                shopUserService = (ShopUserService) factory.getBean("shopUserService");
            }
            ShopUserExample userExample = new ShopUserExample();
            userExample.or().andOpenIdEqualTo(openId);
            ShopUser user = shopUserService.selectFirstByExample(userExample);
            if(user == null){ // 创建关注用户
                String nickName = "滕勇";// 上线后要改为从微信获取
                String headUrl = "";// 上线后要改为从微信获取
                user = new ShopUser();
                user.setOpenId(openId);
                user.setWeiNickName(nickName);
                user.setHeadUrl(headUrl);

                // 获取6位推荐码，查询数据库，推荐码存在，就重新获取
                String code = null;
                while(true){
                    code = RamdonUtil.getSixCode();
                    userExample = new ShopUserExample();
                    userExample.or().andRCodeEqualTo(code);
                    int count = shopUserService.countByExample(userExample);
                    if(count <= 0){
                        break;
                    }
                }
                user.setrCode(code);
                user.setOutCash(0);
                user.setMoney(0);
                short rank = 1;
                user.setRank(rank);

                shopUserService.insert(user);
            }
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("openId", openId);
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
