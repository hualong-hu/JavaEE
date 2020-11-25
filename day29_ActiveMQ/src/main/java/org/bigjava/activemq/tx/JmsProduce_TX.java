package org.bigjava.activemq.tx;

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
public class JmsProduce_TX {
    public static final String ACTIVE_URL = "tcp://150.158.5.94:61616/";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        //1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、通过连接工厂获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3、创建会话session
        /*两个参数：
            第一个参数是事务：若开启事务，一定要在session关闭前提交事务
            第二个参数是签收：
        */

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列queue还是主题topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //设置队列的非持久化，队列默认是持久化
//        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        //6、通过使用消息生产者messageProducer生成3条消息发送到MQ的队列里面
        for (int i = 1; i <=3 ; i++) {
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("MessageListener----" + i);
            //8、通过messageProducer发送给MQ
            messageProducer.send(textMessage);

//            MapMessage mapMessage = session.createMapMessage();
//            mapMessage.setString("k1", "mapMessage------->v1");
//            messageProducer.send(mapMessage);
        }
        //9、关闭资源
        messageProducer.close();
//        session.commit();
        session.close();
        connection.close();

        System.out.println("*****消息发布到MQ完成*****");
    }
}
