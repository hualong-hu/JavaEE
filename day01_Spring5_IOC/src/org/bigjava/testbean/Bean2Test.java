package org.bigjava.testbean;

import org.bigjava.service.TestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: Bean2Test
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-05 22:30
 * @Version v1.0
 */
public class Bean2Test {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        TestService service = context.getBean("testService", TestService.class);

        System.out.println("service = " + service);
        service.test();


    }
}
