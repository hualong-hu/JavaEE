import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.bigjava.config.MainConfigProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.activation.DataSource;

/**
 * @ProjectName: JavaEE
 * @ClassName: ProfileTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 17:49
 * @Version v1.0
 */
public class ProfileTest {

    /**
     * 1、使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=test
     * 2、代码方式激活某种环境如下
     *
     * @data: 2020-08-17-18:11
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void test(){
        //1.创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("development");
        //3.注册主配置类
        applicationContext.register(MainConfigProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] names = applicationContext.getBeanNamesForType(ComboPooledDataSource.class);
        for (String name : names) {
            System.out.println("name = " + name);
        }
        Object red = applicationContext.getBean("red");
        System.out.println("name = " + red);
    }
}
