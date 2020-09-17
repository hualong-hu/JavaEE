package org.bigjava.spring5.test;


import org.bigjava.spring5.dao.UserDAOImpl;
import org.bigjava.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ProjectName: JavaEE
 * @ClassName: Junit4Test
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-12 16:49
 * @Version v1.0
 */
//单元测试框架（junit4）
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration("classpath:bean1.xml")
public class Junit4Test {

    /**
     * 函数式风格创建对象，交给spring进行管理
     * @data: 2020-07-13-10:32
     * @method: test3
     * @params: []
     * @return: void
     */
    @Test
    public void test1(){
        //1.创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2.调用context的方法进行对象注册·
        context.refresh();
        context.registerBean("userDAOImpl", UserDAOImpl.class, () -> new UserDAOImpl());
        //3.获取在spring注册的对象
        UserDAOImpl userDAOImpl = (UserDAOImpl) context.getBean("userDAOImpl");
        System.out.println("userDAOImpl = " + userDAOImpl);
    }

    @Autowired
    private UserService userService;

    @Test
    public void test2() {
        userService.transfer();
    }
}
