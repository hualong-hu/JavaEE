package org.bigjava.activemq.asyncsends;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.util.UUID;

/**
 * @ProjectName: JavaEE
 * @ClassName: JmsProduce
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-10 14:56
 * @Version v1.0
 */
public class QueueProduce {
    public static final String ACTIVE_URL = "tcp://150.158.5.94:61616";
    public static final String QUEUE_NAME = "asyncsends";

    public static void main(String[] args) throws JMSException {
        //1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        //2、通过连接工厂获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();

        //开启异步投递
        activeMQConnectionFactory.setAlwaysSessionAsync(true);

        connection.start();
        //3、创建会话session
        //两个参数：第一个参数是事务/第二个参数是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列queue还是主题topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        //5、创建消息的生产者
        ActiveMQMessageProducer activeMQMessageProducer = (ActiveMQMessageProducer) session.createProducer(queue);

        //6、通过使用消息生产者messageProducer生成3条消息发送到MQ的队列里面
        for (int i = 1; i <=3 ; i++) {
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("async sends msg----" + i);
            //设置消息头
            textMessage.setJMSMessageID(UUID.randomUUID().toString()+"---->luosheng");
            final String messageID = textMessage.getJMSMessageID();
            //8、使用ActiveMQMessageProducer的发送消息,可以创建回调，确保异步消息发送成功
            activeMQMessageProducer.send(textMessage, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("messageID = " + messageID + "success");
                }

                @Override
                public void onException(JMSException exception) {
                    System.out.println("messageID = " + messageID + "fail");
                }
            });
        }
        //9、关闭资源
        activeMQMessageProducer.close();
        session.close();
        connection.close();

        System.out.println("*****消息发布到MQ完成*****");
    }
}
