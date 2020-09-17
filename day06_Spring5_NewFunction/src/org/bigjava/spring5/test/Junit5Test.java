package org.bigjava.spring5.test;
import org.bigjava.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ProjectName: JavaEE
 * @ClassName: Junit5Test
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-13 17:27
 * @Version v1.0
 */
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class Junit5Test {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.transfer();
    }
}
