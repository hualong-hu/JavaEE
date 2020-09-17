import org.bigjava.bean.Person;
import org.bigjava.config.MainConfig;
import org.bigjava.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @ProjectName: JavaEE
 * @ClassName: IOCTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 13:00
 * @Version v1.0
 */
public class IOCTest {
    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void testComponentScan(){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }

    @Test
    public void testConditional(){
        //获取到系统运行环境
        ConfigurableEnvironment environment = context.getEnvironment();
        //动态获取环境变量的值：Windows 10
        String property = environment.getProperty("os.name");
        System.out.println("property = " + property);

        //获取到IOC容器中Person类所有的bean的名字
        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println("name = " + name);
        }
        //获取bean中的所有对象
        Map<String, Person> beans = context.getBeansOfType(Person.class);
        System.out.println("beans = " + beans);
    }
    @Test
    public void testImport(){
        printBeans(context);
        Object bean = context.getBean("colorFactoryBean");
        Object bean1 = context.getBean("&colorFactoryBean");
        System.out.println("bean = " + bean);
        System.out.println("bean = " + bean1);
        System.out.println(bean.getClass());
        System.out.println(bean1.getClass());
    }

    /**
     * 获取容器中所有的组件名
     * @data: 2020-08-16-17:57
     * @method: printBeans
     * @params: [context]
     * @return: void
     */
    public void printBeans( AnnotationConfigApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
