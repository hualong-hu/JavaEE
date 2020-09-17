package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: JavaEE
 * @ClassName: ViewResolverTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-21 17:06
 * @Version v1.0
 */
@Controller
public class ViewResolverTest {
    /**
     * 请求转发：forward:/success.jsp
     * forward:转发到一个页面
     * /success.jsp：转发到当前项目下的success.jsp页面；一定要加上/，如果不加/就算相对路径，容易出问题
     * forward：前缀的转发，不会由我们配置的视图解析器拼串
     *
     * @data: 2020-07-21-17:08
     * @method: forward1
     * @params: []
     * @return: java.lang.String
     */
    @RequestMapping("/pages/forward1")
    public String forward1(){
        System.out.println("forward1!!!!!");
        return "forward:/success.jsp";
    }

    @RequestMapping("/pages/forward2")
    public String forward2(){
        System.out.println("forward2!!!!!");
        return "forward:/pages/forward1";
    }
    /**
     * 重定向：redirect:/success.jsp
     *  有前缀的转发和重定向操作，配置的视图解析器就不会进行拼串
     *
     * 转发      forward:转发的路径
     * 重定向    redirect：重定向的路径
     *          /success.jsp：代表就是从当前项目下开始；SpringMVC会为路径自动的拼接上项目名
     *
     *          原生的Servlet重定向/路径需要加上项目名才能成功
     *          response.sendRedirect("/success.jsp");
     *
     * @data: 2020-07-21-17:23
     * @method: redirect1
     * @params: []
     * @return: java.lang.String
     */
    @RequestMapping("/pages/redirect1")
    public String redirect1(){
        System.out.println("redirect1！！！！！！！");
        return "redirect:/success.jsp";
    }
    @RequestMapping("/pages/redirect2")
    public String redirect2() {
        System.out.println("redirect2！！！！！！！");
        return "redirect:/pages/redirect1";
    }
}
