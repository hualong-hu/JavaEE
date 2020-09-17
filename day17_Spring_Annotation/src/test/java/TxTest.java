import org.bigjava.config.MainConfigTx;
import org.bigjava.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: TxTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 17:06
 * @Version v1.0
 */
public class TxTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(MainConfigTx.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
    }
}
