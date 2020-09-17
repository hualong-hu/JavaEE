package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: JavaEE
 * @ClassName: RequestMappingAntTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-15 20:14
 * @Version v1.0
 *
 *  @RequestMapping模糊匹配功能
 *  URL地址可以写模糊的通配符：
 *      ?:能替代任意一个字符,0个或多个都不行
 *      *:能替代任意多个字符，和一层路径
 *      **:能替代多层路径
 *  模糊匹配和精确匹配的情况下，精确优先
 *
 *
 */
@Controller
public class RequestMappingAntTest {

    @RequestMapping(value = "/antTest1")
    public String test1(){
        System.out.println("test1..........");
        return "success";
    }

    @RequestMapping(value = "/antTest?")
    public String test2(){
        System.out.println("test2..........");
        return "success";
    }

    @RequestMapping(value = "/antTest*")
    public String test3(){
        System.out.println("test3..........");
        return "success";
    }
    @RequestMapping(value = "/a/*/antTest?")
    public String test4(){
        System.out.println("test4..........");
        return "success";
    }
    @RequestMapping(value = "/**/antTest?")
    public String test5(){
        System.out.println("test5..........");
        return "success";
    }
    /**
     * 路径上可以有占位符，占位符语法就是可以在任意路径的地方写一个{变量名}
     * 路径上的占位符只能占一层路径
     * @data: 2020-07-15-20:44
     * @method: pathVariableTest
     * @params: [id]
     * @return: java.lang.String
     */
    @RequestMapping("/user/{id}")
    public String pathVariableTest(@PathVariable("id")String id){
        System.out.println("路径上的占位符的值是"+id);
        return "success";
    }
}
