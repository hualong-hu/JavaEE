package org.bigjava.controller;


import org.bigjava.POJO.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: JavaEE
 * @ClassName: GetParams
 * @Description: 测试SpringMVC获取请求中的各种信息
 * @Author: 洛笙
 * @Date: 2020-07-17 13:20
 * @Version v1.0
 *
 * SpringMVC如何获取请求带来的各种信息
 * 默认方法获取请求参数
 *      直接给方法入参上写一个和请求参数名相同的变量，这个变量就是来接收请求参数的值
 *      带，有值；没带，null。
 * @RequestParam： 获取请求参数的,参数默认是必须，不带就报错
 *      @RequestParam("user") String username
 *      等同于 String username = request.getParameter("user")
 *      三个属性：
 *          value：指定要获取的参数的key
 *          required：这个参数是否必须有
 *          defaultValue：默认值，没带参数默认为null
 *
 * @RequestHeader： 获取请求头中的某个key的值，如果请求头中没有这个key就会报错
 *      @RequestHeader("User-Agent") String agent
 *      等同于 String agent = request.getHeader("User-Agent")
 *      三个属性：
 *          value：指定要获取的参数的key
 *          required：这个参数是否必须有
 *          defaultValue：默认值，没带参数默认为null
 * @CookieValue： 获取某个cookie值
 *      @CookieValue("JSESSIONID") String cookie
 *      等同于
 *          Cookie[] cookies = request.getCookies();
 *          for(Cookie c : cookies){
 *              if(c.getName().equals("JSESSIONID")){
 *                  String cv = c.getValue();
 *              }
 *          }
 *      三个属性：
 *         value：指定要获取的参数的key
 *         required：这个参数是否必须有
 *         defaultValue：默认值，没带参数默认为null
 */
@Controller
public class GetParams {
    @RequestMapping(value = "/pages/param1")
    public String getParams(@RequestParam(value = "username",required = false,defaultValue = "没带参数") String username,
                             @RequestHeader(value = "User-Agent",required = false,defaultValue = "该请求头信息不存在") String agent,
                             @CookieValue(value = "JSESSIONID",required = false,defaultValue = "该cookie不存在") String cookie){
        System.out.println("username = " + username);
        System.out.println("请求头的User-Agent的信息是："+agent);
        System.out.println("Cookie中JSESSIONID的值是："+cookie);
        return "success";
    }
    /**
     * 如果我们的请求参数是一个POJO，SpringMVC会自动的为这个POJO赋值
     *  1、将POJO中的每一个属性从request参数中尝试获取出来，并封装即可
     *  2、还可以进行级联封装
     * @data: 2020-07-17-17:04
     * @method: getBook
     * @params: [book]
     * @return: java.lang.String
     */
    @RequestMapping(value = "/pages/addBook")
    public String getBook(Book book,HttpServletRequest request) {

        System.out.println("添加的图书信息是："+book);
        return "success";
    }

    @RequestMapping(value = "/pages/param2")
    public String test(HttpServletRequest request, HttpSession session){
        request.setAttribute("request", "我是request域中的数据");
        session.setAttribute("session","我是Session域中的数据");
        return "success";
    }
}
