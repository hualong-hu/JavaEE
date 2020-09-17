package org.bigjava.service;

import org.bigjava.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-05 22:27
 * @Version v1.0
 */
@Service
public class TestService {

    @Value("刘雯静")
    private String name;
    @Value("11")
    private List<Integer> age;
    /**
     * 定义dao类型属性，不需要添加set方法，添加注入属性注释
     */
    //根据类型进行注入
//    @Autowired
//    //根据名称进行注入
//    @Qualifier(value = "userDAOImpl")
//    @Resource //根据类型进行注入
    @Resource(name = "userDAOImpl")
    private UserDAO userDao;

    public void test(){
        System.out.println("test注解执行！！！"+name+age);
        userDao.update();
    }
}
