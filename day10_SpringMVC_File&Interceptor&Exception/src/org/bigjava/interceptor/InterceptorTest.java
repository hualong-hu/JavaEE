package org.bigjava.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: JavaEE
 * @ClassName: InterceptorTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-28 15:43
 * @Version v1.0
 */
@Controller
public class InterceptorTest {

    @RequestMapping(value="test1")
    public String  test1(){
        System.out.println("test1！！！！！！！！！！");
        return "success";
    }

    @RequestMapping(value="/test2")
    public String  test2(){
        System.out.println("test2！！！！！！！！！！");
        return "success";
    }
}
