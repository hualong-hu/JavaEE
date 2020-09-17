import org.bigjava.config.LifeCycleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: LifeCycleTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 13:24
 * @Version v1.0
 */
public class LifeCycleTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成......");
//        Object car = applicationContext.getBean("car");
//        System.out.println("car = " + car);
        applicationContext.close();
    }
    /*
    car创建
car初始化
容器创建完成......
car = org.bigjava.bean.CarLifeCycle@667a738
     */
}
