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
public class QueueConsumer {

    public static final String ACTIVE_URL = "tcp://150.158.5.94:61616";
    public static final String QUEUE_NAME = "jdbc01";

    public static void main(String[] args) throws JMSException, IOException {
        //1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、通过连接工厂获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3、创建会话session
        //两个参数：第一个参数是事务/第二个参数是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列queue还是主题topic）
        Queue queue = session.createQueue(QUEUE_NAME);

        //5、创建消费者
        MessageConsumer consumer = session.createConsumer(queue);

        /*
        同步阻塞方式（receive()）
        订阅者或接收者调用consumer的receive()方法来接收消息，receive()方法在能够接收到消息之前（或超时之前）将一直阻塞
        */
        while (true){
            TextMessage message = (TextMessage) consumer.receive(4000L);
            if (message != null){
                System.out.println("*****消费者接收到的消息是："+message.getText());
            }else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();
    }

}
