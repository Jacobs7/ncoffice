package com.dape.shop.web.interceptor;

import com.dape.common.util.MD5Util;
import com.dape.common.util.PropertiesFileUtil;
import com.dape.common.util.RamdonUtil;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;
import com.dape.shop.dao.model.UpmsUser;
import com.dape.shop.rpc.api.ShopUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

public class ShopWebInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopWebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 过滤ajax
        if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            return true;
        }

        String url = request.getRequestURI();
        Object u = request.getSession().getAttribute("upmsuser");
        if(url.equals("/login/")){

        }else if(u == null){
            String openId = "";// 要改为从微信获取
            String nickName = "滕勇";// 上线后要改为从微信获取
            String headUrl = "";// 上线后要改为从微信获取

            if(StringUtils.isBlank(openId)){
                if(url.equals("/") || url.startsWith("/goods") || url.startsWith("/module") || url.startsWith("/resources")){// 不登录也可访问的地址

                }else{
                    response.sendRedirect("/login/");
                    return false;
                }
            }else{
                BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
                ShopUserService shopUserService = (ShopUserService) factory.getBean("shopUserService");
                UpmsUser upmsUser = shopUserService.selectUpmsUserByOpenid(openId);
                ShopUser shopUser = null;
                if(upmsUser == null){// 未查到，新增微信用户
                    UpmsUser newUser = new UpmsUser();
                    String salt = UUID.randomUUID().toString().replaceAll("-", "");
                    newUser.setUsername(openId);
                    newUser.setSalt(salt);
                    newUser.setPassword(MD5Util.md5("" + salt));
                    newUser.setCtime(System.currentTimeMillis());
                    newUser.setLocked((byte)0);
                    newUser.setPhone("");
                    newUser.setOpenid(openId);
                    shopUserService.createUser(newUser);
                    upmsUser = shopUserService.selectUpmsUserByOpenid(openId);

                    shopUser = new ShopUser();
                    shopUser.setUserId(upmsUser.getUserId());
                    shopUser.setWeiNickName(nickName);
                    shopUser.setHeadUrl(headUrl);
                    // 获取6位推荐码，查询数据库，推荐码存在，就重新获取
                    String code = null;
                    while(true){
                        code = RamdonUtil.getSixCode();
                        ShopUserExample userExample = new ShopUserExample();
                        userExample.or().andRCodeEqualTo(code);
                        int count = shopUserService.countByExample(userExample);
                        if(count <= 0){
                            break;
                        }
                    }
                    shopUser.setrCode(code);
                    shopUser.setOutCash(0);
                    shopUser.setMoney(0);
                    short rank = 1;
                    shopUser.setRank(rank);
                    shopUser.setCreateDate(new Date());
                    shopUser.setIntegral(0);
                    shopUserService.insert(shopUser);

                    ShopUserExample userExample = new ShopUserExample();
                    userExample.or().andUserIdEqualTo(upmsUser.getUserId());
                    shopUser = shopUserService.selectFirstByExample(userExample);
                }else{
                    ShopUserExample shopUserExample = new ShopUserExample();
                    shopUserExample.or().andUserIdEqualTo(upmsUser.getUserId());
                    shopUser = shopUserService.selectFirstByExample(shopUserExample);
                }
                request.getSession().setAttribute("upmsuser", upmsUser);
                request.getSession().setAttribute("shopuser", shopUser);
            }
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
