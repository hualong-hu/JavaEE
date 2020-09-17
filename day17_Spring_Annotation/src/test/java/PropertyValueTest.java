import org.bigjava.config.MainConfigPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: PropertyValueTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 15:52
 * @Version v1.0
 */
public class PropertyValueTest {
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfigPropertyValue.class);

    @Test
    public void test(){
        printBeans(applicationContext);
        Object person = applicationContext.getBean("person");
        System.out.println("person = " + person);
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
