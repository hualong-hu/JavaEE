package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyFirstController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-15 12:32
 * @Version v1.0
 *
 * 1.告诉SpringMVC这是一个处理器，可以处理请求
 *      @Controller：标识哪个组件是控制器
 *
 * 2.运行流程
 *  1）、客户端点击链接会发送http://localhost:8080/springmvc/hello
 *  2)、来到tomcat服务器
 *  3）、SpringMVC的前端控制器收到所有请求
 *  4）、来看请求地址和@RequestMapping标注的哪个匹配，来找到到底使用哪个类的哪个方法
 *  5）、前端控制器找到了目标处理器类和目标方法，直接利用反射执行目标方法
 *  6）、方法执行完以后会有一个返回值，SpringMVC认为这个返回值就是要去的页面地址
 *  7）、拿到方法返回值以后，用视图解析器进行拼串得到完整的页面地址
 *  8）、拿到页面地址后，前端控制器帮我们转发到页面
 *
 * 3.@RequestMapping：
 *  就是告诉SpringMVC这个方法用来处理什么请求
 *  这个/可以省略，即使省略了，也是默认从当前项目下开始；
 *  习惯加上比较好
 *
 * 4.如果不指定配置文件位置
 *  如果不指定也会默认去找一个文件：
 *      /WEB-INFO/springDispatcherServlet-servlet.xml
 *      可以在web应用的/WEB-INFO下创建一个名叫：前端控制器名-servlet.xml的配置文件
 *
 */
@Controller
public class MyFirstController {
    /**
     * /代表从当前项目下开始，处理当前项目下的hello请求
     */
    @RequestMapping("/hello")
    public String myFirstRequest() {
        System.out.println("请求收到。。。。。开始处理！！！！");
        //视图解析器自动拼串
//        <property name="prefix" value="/pages/"/>
//        <property name="suffix" value=".jsp"/>
        // 前缀（/pages/）+返回值（success）+后缀（.jsp）
        return "success";
    }
}
