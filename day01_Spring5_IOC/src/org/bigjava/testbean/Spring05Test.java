package org.bigjava.testbean;
import org.bigjava.bean.Book;
import org.bigjava.bean.Person;
import org.bigjava.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: Spring05Test
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-25 17:20
 * @Version v1.0
 */
public class Spring05Test {
    @Test
    public void test01(){
        //1.创建spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println("user = " + user);
        user.add();

    }
    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Book book = context.getBean("book", Book.class);

        System.out.println("book = " + book);
    }
    @Test
    public void testBook1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Book book1 = context.getBean("book1", Book.class);

        System.out.println("book1 = " + book1);

    }
    @Test
    public void testBook2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Book book2 = context.getBean("book2", Book.class);

        System.out.println("book2 = " + book2);

    }
    @Test
    public void testPerson1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Person person = context.getBean("person1", Person.class);

        System.out.println("person = " + person);

    }
}
