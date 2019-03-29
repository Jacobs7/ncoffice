package com.dape.upms.common.constant;

import com.dape.common.base.BaseConstants;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * mq接收消息测试代码(学习代码)
 */
public class MQReceiverTest extends BaseConstants {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory;// ConnectionFactory ：连接工厂，JMS 用它创建连接
        Connection connection = null;// Connection ：JMS 客户端到JMS Provider 的连接
        Session session;// Session： 一个发送或接收消息的线程
        Destination destination;// Destination ：消息的目的地;消息发送给谁.
        MessageConsumer consumer;// 消费者，消息接收者
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        try {
            connection = connectionFactory.createConnection();// 构造从工厂得到连接对象
            connection.start();// 启动
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);// 获取操作连接
            destination = session.createQueue("FirstQueue");// 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            consumer = session.createConsumer(destination);
            while (true) {
                // 设置接收者接收消息的时间，为了便于测试，这里谁定为100s
                TextMessage message = (TextMessage) consumer.receive(500000);
                if (null != message) {
                    System.out.println("收到消息" + message.getText());
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }
}
