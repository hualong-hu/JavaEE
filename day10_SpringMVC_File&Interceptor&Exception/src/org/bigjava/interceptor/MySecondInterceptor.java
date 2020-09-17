package org.bigjava.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: JavaEE
 * @ClassName: MySecondInterceptor
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-28 16:57
 * @Version v1.0
 */
public class MySecondInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MySecondInterceptor!!!!!!preHandle!!!!!!!");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MySecondInterceptor!!!!!!postHandle!!!!!!!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MySecondInterceptor!!!!!!afterCompletion!!!!!!!");
    }
}
