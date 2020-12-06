package org.bigjava.test;

import org.bigjava.aopanno.Student;
import org.bigjava.aopanno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;

/**
 * @ProjectName: JavaEE
 * @ClassName: AopTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-09 23:53
 * @Version v1.0
 */
public class AopTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);

        user.add();

    }
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test1.xml");

        Student student = ctx.getBean("student", Student.class);

        student.show();

    }
}
