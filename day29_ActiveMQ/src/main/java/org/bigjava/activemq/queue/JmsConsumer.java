package org.bigjava.activemq.queue;

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
public class JmsConsumer {

    public static final String ACTIVE_URL = "tcp://150.158.5.94:61616/";
    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("我是2号消费者");
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
        */

        //通过监听的方法来消费消息
        /*
            异步非阻塞方式（监听器MessageListener）
            订阅者或接收者通过consumer的setMessageListener方法注册一个消息监听器
            当消息到达之后，系统自动调用监听器MessageListener的onMessage(Message message)方法
         */
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message != null && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("*****消费者接收到的消息是："+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
//                if (message != null && message instanceof MapMessage){
//                    MapMessage mapMessage = (MapMessage) message;
//                    try {
//                        System.out.println("*****消费者接收到的消息是："+mapMessage.getString("k1"));
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        });
        // 保证控制台不灭  不然activemq 还没连上就关掉了连接
        System.in.read();
        consumer.close();
        session.close();
        connection.close();


    }

}
