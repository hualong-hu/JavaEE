import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @ProjectName: JavaEE
 * @ClassName: MainApplication
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-03 10:57
 * @Version v1.0
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.in.read();

    }
}
