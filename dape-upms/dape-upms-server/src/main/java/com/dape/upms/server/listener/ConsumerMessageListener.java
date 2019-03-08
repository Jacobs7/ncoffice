package com.dape.upms.server.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dape.common.util.RedisUtil;
import com.dape.upms.client.shiro.session.UpmsSession;
import com.dape.upms.client.shiro.session.UpmsSessionDao;
import com.dape.upms.common.constant.UpmsResult;
import com.dape.upms.common.constant.UpmsResultConstant;
import com.dape.upms.rpc.api.UpmsSystemService;
import com.dape.upms.rpc.api.UpmsUserService;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.UUID;

public class ConsumerMessageListener implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMessageListener.class);

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    // 全局会话key
    private final static String DAPE_UPMS_SERVER_SESSION_ID = "dape-upms-server-session-id";
    // 全局会话key列表
    private final static String DAPE_UPMS_SERVER_SESSION_IDS = "dape-upms-server-session-ids";
    // code key
    private final static String DAPE_UPMS_SERVER_CODE = "dape-upms-server-code";



    @Autowired
    UpmsSessionDao upmsSessionDao;

    @Override
    public void onMessage(final Message message) {
        // 使用线程池多线程处理
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println(text);
                    JSONObject jsonObject = JSON.parseObject(text);
                    String username = jsonObject.get("username").toString();
                    String password = jsonObject.get("pwd").toString();
                    //String rememberMe = request.getParameter("rememberMe");
                    if (StringUtils.isBlank(username)) {

                    }
                    if (StringUtils.isBlank(password)) {

                    }
                    Subject subject = SecurityUtils.getSubject();
                    Session session = subject.getSession();
                    String sessionId = session.getId().toString();
                    // 判断是否已登录，如果已登录，则回跳，防止重复登录
                    String hasCode = RedisUtil.get(DAPE_UPMS_SERVER_SESSION_ID + "_" + sessionId);

                    // code校验值
                    if (StringUtils.isBlank(hasCode)) {
                        // 使用shiro认证
                        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
                        try {
                            if (BooleanUtils.toBoolean(true)) {
                                usernamePasswordToken.setRememberMe(true);
                            } else {
                                usernamePasswordToken.setRememberMe(false);
                            }
                            //验证用户名密码
                            subject.login(usernamePasswordToken);
                        } catch (UnknownAccountException e) {
                            upmsSessionDao.loginfail(sessionId, UpmsSession.OnlineStatus.not_exit.toString());

                    } catch (IncorrectCredentialsException e) {
                            upmsSessionDao.loginfail(sessionId, UpmsSession.OnlineStatus.login_fail.toString());

                    } catch (LockedAccountException e) {
                            upmsSessionDao.loginfail(sessionId, UpmsSession.OnlineStatus.loacked.toString());

                    }
                    // 更新session状态
//                    upmsSessionDao.updateStatus(sessionId, UpmsSession.OnlineStatus.on_line);
//                        // 全局会话sessionId列表，供会话管理
//                        RedisUtil.lpush(DAPE_UPMS_SERVER_SESSION_IDS, sessionId.toString());
//                        // 默认验证帐号密码正确，创建code
//                        String code = UUID.randomUUID().toString();
//                        // 全局会话的code
//                        RedisUtil.set(DAPE_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) subject.getSession().getTimeout() / 1000);
//                        // code校验值
//                        RedisUtil.set(DAPE_UPMS_SERVER_CODE + "_" + code, code, (int) subject.getSession().getTimeout() / 1000);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
