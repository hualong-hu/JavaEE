package org.bigjava.spring5.test;

import org.bigjava.spring5.config.TransactionConfig;
import org.bigjava.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: TransactionTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-12 16:49
 * @Version v1.0
 */
public class TransactionTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
    UserService userService = context.getBean("userService", UserService.class);
    @Test
    public void test1() {
        userService.transfer();
    }
    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.transfer();
    }
}
