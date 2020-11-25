package org.bigjava.activemq.jdbc;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ProjectName: JavaEE
 * @ClassName: JmsProduce
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-10 14:56
 * @Version v1.0
 */
public class TopicProduce {
    public static final String ACTIVE_URL = "tcp://150.158.5.94:61616/";
    public static final String TOPIC_NAME = "topic--JDBC";

    public static void main(String[] args) throws JMSException {
        //1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、通过连接工厂获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();

        //3、创建会话session
        //两个参数：第一个参数是事务/第二个参数是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列queue还是主题topic）
        Topic topic = session.createTopic(TOPIC_NAME);
        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(topic);
        //设置topic持久化
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();

        //6、通过使用消息生产者messageProducer生成3条消息发送到MQ的队列里面
        for (int i = 1; i <=5 ; i++) {
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("topic01----" + i);
            //8、通过messageProducer发送给MQ
            messageProducer.send(textMessage);
        }
        //9、关闭资源
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("*****消息发布到MQ完成*****");
    }
}
