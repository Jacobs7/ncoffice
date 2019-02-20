package com.dape.shop.web.controller;

import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import com.taobao.api.internal.tmc.TmcClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TaobaoFuwuOrderCreated implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
//        TmcClient client = new TmcClient("25632498", "51e06e43ebc6f093579131f6c7fcd568", "default");
//        client.setMessageHandler(new MessageHandler() {
//            public void onMessage(Message message, MessageStatus status) {
//                try {
//                    System.out.println("*************************************************************************************");
//                    System.out.println("*************************************************************************************");
//                    System.out.println("************************************** 接收消息 start *******************************");
//                    System.out.println("*************************************************************************************");
//                    System.out.println("*************************************************************************************");
//                    System.out.println("内容:" + message.getContent());
//                    System.out.println("topic:" + message.getTopic());
//                    System.out.println("*************************************************************************************");
//                    System.out.println("*************************************************************************************");
//                    System.out.println("************************************** 接收消息 end *******************************");
//                    System.out.println("*************************************************************************************");
//                    System.out.println("*************************************************************************************");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    status.fail();
//                    // 消息处理失败回滚，服务端需要重发
//                    // 重试注意：不是所有的异常都需要系统重试。
//                    // 对于字段不全、主键冲突问题，导致写DB异常，不可重试，否则消息会一直重发
//                    // 对于，由于网络问题，权限问题导致的失败，可重试。
//                    // 重试时间 5分钟不等，不要滥用，否则会引起雪崩
//                }
//            }
//        });
//        client.connect("ws://mc.api.taobao.com");
    }
}
