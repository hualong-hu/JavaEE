package org.bigjava.activemq.ScheduledMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;

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
    public static final String QUEUE_NAME = "延时投递";

    public static void main(String[] args) throws JMSException {
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
        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);



        //6、通过使用消息生产者messageProducer生成3条消息发送到MQ的队列里面
        for (int i = 1; i <=3 ; i++) {
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("delay msg----" + i);
            //延时投递的时间
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 3000);
            //重复投递的时间间隔
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 4000);
            //重复投递次数
            textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 5);
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
