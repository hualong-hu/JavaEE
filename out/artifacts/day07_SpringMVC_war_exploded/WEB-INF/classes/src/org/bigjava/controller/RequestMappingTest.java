package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: JavaEE
 * @ClassName: RequestMappingTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-15 18:15
 * @Version v1.0
 */

/**
    为当前类的所有方法的请求地址指定一个基准路径
 */
@RequestMapping("/haha")
@Controller
public class RequestMappingTest {

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("RequestMappingTest........hello1");
        return "success";
    }
    /**
     * 测试RequestMapping的其他属性
     *  1、method：限定请求方式;
     *      HTTP协议中的所有请求方式：【GET】, HEAD, 【POST】, PUT, PATCH, DELETE, OPTIONS, TRACE
     *      method = RequestMethod.POST，只接受POST类型的请求，默认是所有请求都接收
     *      不是规定的请求方式报错：HTTP Status 405 - Request method 'GET' not supported
     *  2、params:规定请求参数
     *      param1:表示请求必须包含名为param1的请求参数
     *          eg：params = {"username"}：表示发送请求的时候必须带上一个名为username的参数
     *      !param1:表示请求不能包含名为param1的请求参数
     *          eg：params = {"!username"}：表示发送请求的时候不能带上一个名为username的参数，带上就会报错
     *      param1 != value1 ：表示请求包含名为param1的请求参数，且其值不能为value1
     *          eg:params = {"username!=123"}:表示发送请求时，携带的username的值不能是123（不带username或者username的值为空都行）
     *      {"param1=value1","param2"}:请求必须包含名为param1和param2，且param1的值必须为value1
     *          eg：params = {"username!=123","password","!age"}
     *          表示请求的username的值不能为123，且必须有password的参数，且不能包含age参数
     *  3、headers:规定请求头，也和params一样能写简单的表达式
     *  以下两个只需了解即可
     *  4、consumes：只接受内容类型是哪种的请求，规定请求头中的Content-Type
     *  5、produces：告诉浏览器返回的内容类型是什么，给响应头中加上Content-Type：text/html;charset=utf-8
     *
     *
     */
    @RequestMapping(value = "/test2",method = RequestMethod.POST)
    public String test2(){
        return "success";
    }

    @RequestMapping(value = "/test3" ,params = {"username!=123","password","!age"})
    public String test3(){
        System.out.println("test3...............");
        return "success";
    }
    /**
     *  User-Agent:浏览器信息，
     *  设置只允许谷歌访问：
     *  User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4168.2 Safari/537.36
     */
    @RequestMapping(value = "/test4",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4168.2 Safari/537.36"})
    public String test4(){
        System.out.println("test4...............");

        return "success";
    }
}
