package org.bigjava.activemq.jdbc;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @ProjectName: JavaEE
 * @ClassName: JmsConsumer
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-10 15:25
 * @Version v1.0
 */
public class TopicConsumer {

    public static final String ACTIVE_URL = "tcp://150.158.5.94:61616/";
    public static final String TOPIC_NAME = "topic--JDBC";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("消费者启动！！！");
        //1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、通过连接工厂获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("张三");

        //3、创建会话session
        //两个参数：第一个参数是事务/第二个参数是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列queue还是主题topic）
        Topic topic = session.createTopic(TOPIC_NAME);
        //设置topic的订阅者
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "MQ-JDBC");

        /*
            一定要先运行一次消费者，等于MQ注册，类似于订阅了这个主题。然后在运行生产者发送信息
            此时，无论消费者是否在线，都会接收到，不在线的话，下次连接的时候，会把没有收到的消息都接收下来
         */
        connection.start();
        Message message = topicSubscriber.receive();
        while (message != null){
            TextMessage textMessage = (TextMessage) message;
            System.out.println("收到的持久化topic = " + textMessage.getText());
            message = topicSubscriber.receive(3000L);
        }

        session.close();
        connection.close();


    }

}
