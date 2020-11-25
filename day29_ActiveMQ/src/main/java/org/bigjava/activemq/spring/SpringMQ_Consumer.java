package org.bigjava.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: JavaEE
 * @ClassName: SpringMQ_Consumer
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 10:25
 * @Version v1.0
 */
@Service
public class SpringMQ_Consumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMQ_Consumer consumer = (SpringMQ_Consumer) context.getBean("springMQ_Consumer");

        String convert = (String) consumer.jmsTemplate.receiveAndConvert();

        System.out.println("消费者收到的消息 = " + convert);
    }
}
