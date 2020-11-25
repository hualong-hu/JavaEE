package org.bigjava.activemq.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyMessageListener
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 17:30
 * @Version v1.0
 */
@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message != null && message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("textMessage = " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
