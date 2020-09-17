import org.bigjava.config.MainConfigAutowired;
import org.bigjava.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: AutowiredTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 16:19
 * @Version v1.0
 */
public class AutowiredTest {
    AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(MainConfigAutowired.class);

    @Test
    public void test(){
        BookService bookService = applicationContext.getBean(BookService.class);
        bookService.print();
    }
}
