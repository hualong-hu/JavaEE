package org.bigjava.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: JavaEE
 * @ClassName: ConcentratedException
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-28 17:47
 * @Version v1.0
 * 1.集中处理所有异常的类加入到IOC容器中使用 @ControllerAdvice
 * 2.@ControllerAdvice专门处理异常的类
 */
@ControllerAdvice
public class ConcentratedException {

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView getException(Exception exception){
        System.out.println("getException......"+exception);
        ModelAndView view = new ModelAndView("myerror");
        view.addObject("exception", exception);
        return view;
    }
}
