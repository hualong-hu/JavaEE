package org.bigjava.activemq.tx;

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
public class JmsConsumer_TX {

    public static final String ACTIVE_URL = "tcp://150.158.5.94:61616/";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("我是1号消费者");
        //1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、通过连接工厂获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3、创建会话session
        //两个参数：第一个参数是事务/第二个参数是签收
        /*
            在事务性会话中，当一个事务被成功提交则消息被自动签收，如果事务回滚，则消息会被再次传送
            非事务会话中，消息何时被确认取决于创建会话时的应答模式（Session.CLIENT_ACKNOWLEDGE，AUTO_ACKNOWLEDGE）
         */
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
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
//                message.acknowledge();
            }else {
                break;
            }
        }
        consumer.close();
        session.commit();
        session.close();
        connection.close();

    }

}
