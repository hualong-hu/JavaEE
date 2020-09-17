
import org.bigjava.aop.MyMath;
import org.bigjava.config.MainConfigAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: AOPTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 14:11
 * @Version v1.0
 */
public class AOPTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(MainConfigAOP.class);
//        printBeans(applicationContext);
        MyMath myMath = applicationContext.getBean(MyMath.class);
        System.out.println("myMath = " + myMath);
        myMath.division(1, 0);
    }

    public void printBeans( AnnotationConfigApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
