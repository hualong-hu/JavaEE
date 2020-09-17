import org.bigjava.bean.Person;
import org.bigjava.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: MainTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 12:41
 * @Version v1.0
 */
public class MainTest {

    @Test
    public void test1(){

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person);
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println("person = " + person);

        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
