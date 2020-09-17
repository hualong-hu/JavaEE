package org.bigjava.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyFirstInterceptor
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-28 15:46
 * @Version v1.0
 *
 * 1、实现HandlerInterceptor接口
 * 2、在SpringMVC配置文件中注册这个拦截器的工作！
 *      配置这个拦截器来拦截哪些请求的目标方法
 * 3、拦截器正常运行流程
 *   拦截器的preHandle() --> 目标方法 --> 拦截器的postHandle() --> 来到页面 --> 拦截器的afterCompletion()
 * 4、其他流程
 *      1.只要preHandle()不放行就没有以后的流程
 *      2.只要preHandle()放行了，afterCompletion()都会执行
 *
 */
public class MyFirstInterceptor implements HandlerInterceptor {
    /**
     * 目标方法运行之前执行；返回boolean；return true == chain.doFilter()放行；return false == 不放行
     * @data: 2020-07-28-15:48
     * @method: preHandle
     * @params: [request, response, handler]
     * @return: boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle！！！！！！！！！！");
        return true;
    }
    /**
     * 在目标方法方法执行之后调用
     * @data: 2020-07-28-16:01
     * @method: postHandle
     * @params: [request, response, handler, modelAndView]
     * @return: void
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle!!!!!!!!!!!!!!!!");
    }
    /**
     * 在请求整个完成之后，来到也能之后调用
     * @data: 2020-07-28-16:01
     * @method: afterCompletion
     * @params: [request, response, handler, ex]
     * @return: void
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion!!!!!!!!!!!!!!");
    }
}
