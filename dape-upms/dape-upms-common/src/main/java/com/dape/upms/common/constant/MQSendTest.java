package com.dape.upms.common.constant;

import com.dape.common.base.BaseConstants;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * mq发送消息测试代码(学习代码)
 */
public class MQSendTest extends BaseConstants {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory; // ConnectionFactory--连接工厂，JMS用它创建连接
        Connection connection = null; // Connection ：JMS 客户端到JMS
        Session session; // Session： 一个发送或接收消息的线程
        Destination destination; // Destination ：消息的目的地;消息发送给谁
        MessageProducer producer; // MessageProducer：消息发送者

        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");

        try {
            connection = connectionFactory.createConnection(); // 构造从工厂得到连接对象
            connection.start(); // 启动
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); // 获取操作连接
            destination = session.createQueue("TestQueue"); // // mq的队列名称，发送与接收要一致
            producer = session.createProducer(destination);// 得到消息生成者【发送者】
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);// 设置不持久化，此处学习，实际根据项目决定
            sendMessage(session, producer);// 构造消息，此处写死，项目就是参数，或者方法获取
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {

            }
        }
    }

    private static final int SEND_NUMBER = 5;

    public static void sendMessage(Session session, MessageProducer producer) throws JMSException{
        for (int i = 1; i <= SEND_NUMBER; i++) {
            TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);
            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            producer.send(message);
        }
    }
}
