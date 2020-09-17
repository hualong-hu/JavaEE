package org.bigjava.testbean;

import org.bigjava.bean.Employee;
import org.bigjava.bean.Student;
import org.bigjava.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: BeanTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-02 16:40
 * @Version v1.0
 */
public class BeanTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.show();
    }
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Employee employee = context.getBean("employee", Employee.class);

        System.out.println("employee = " + employee);


    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Employee emp = context.getBean("emp", Employee.class);

        System.out.println("emp = " + emp);

    }
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        Student student = context.getBean("student", Student.class);

        student.show();

    }
}
