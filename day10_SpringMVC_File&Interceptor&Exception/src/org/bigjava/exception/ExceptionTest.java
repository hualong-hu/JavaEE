package org.bigjava.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: JavaEE
 * @ClassName: ExceptionTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-28 17:25
 * @Version v1.0
 */
@Controller
public class ExceptionTest {

    @RequestMapping(value="/exception1")
    public String  handle01(Integer i){
        System.out.println("handle02..............");
        System.out.println(10/i);
        return "success";
    }
    @RequestMapping(value="/exception2")
    public String  handle02(@RequestParam("username") String username){
        System.out.println("handle02................");
        if (!"admin".equals(username)){
            System.out.println("登录失败");
            throw new UsernameNotFoundException();
        }
        System.out.println("登录成功！");
        return "success";
    }

    @RequestMapping(value="/exception3")
    public String  handle03(){
        System.out.println("handle03.........");
        String str = null;
        System.out.println(str.charAt(0));
        return "success";
    }
    /**
     * 告诉SpringMVC这个方法专门处理这个类发生的异常
     * 1、在方法参数上写一个Exception参数，用来接收发生的异常
     * 2、要携带异常信息不能在参数位置写Model
     * 3、返回ModelAndView即可
     * 4、如果有多个@ExceptionHandler都能处理这个异常，精确优先
     * 5、全局异常和本类同时存在。本类优先
     * @data: 2020-07-28-17:38
     * @method: getException
     * @params: [exception]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView getException(Exception exception){
        System.out.println("getException......"+exception);
        ModelAndView view = new ModelAndView("myerror");
        view.addObject("exception", exception);
        return view;
    }
}
