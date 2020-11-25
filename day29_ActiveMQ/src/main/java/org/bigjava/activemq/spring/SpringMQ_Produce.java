package org.bigjava.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @ProjectName: JavaEE
 * @ClassName: SpringMQ_Produce
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 10:25
 * @Version v1.0
 */
@Service
public class SpringMQ_Produce {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        SpringMQ_Produce produce = (SpringMQ_Produce) context.getBean("springMQ_Produce");

        produce.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage("spring和ActiveMQ的整合case33333");
                return message;
            }
        });

        System.out.println("************send task over");
    }
}
