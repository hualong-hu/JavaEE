package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: JavaEE
 * @ClassName: RestUrlTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-17 0:03
 * @Version v1.0
 */
@Controller
public class RestUrlTest {
    /**
     * 处理查询图书请求
     * @data: 2020-07-17-0:14
     * @method: getBook
     * @params: [id]
     * @return: java.lang.String
     */
    @RequestMapping(value = "/pages/book/{bookId}",method = RequestMethod.GET)
    public String getBook(@PathVariable("bookId") String id){
        System.out.println("查询了"+id+"号图书");
        return "success";
    }
    /**
     * 处理删除图书请求
     * @data: 2020-07-16-16:49
     * @method: deleteBook
     * @params: [id]
     * @return: java.lang.String
     */
    @RequestMapping(value = "/pages/book/{bookId}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bookId") String id){
        System.out.println("删除了"+id+"号图书");
        return "success";
    }
    /**
     * 处理更新图书请求
     * @data: 2020-07-16-16:50
     * @method: putBook
     * @params: [id]
     * @return: java.lang.String
     */
    @RequestMapping(value = "/pages/book/{bookId}",method = RequestMethod.PUT)
    public String putBook(@PathVariable("bookId") String id){
        System.out.println("更新了"+id+"号图书");
        return "success";
    }
    /**
     * 处理添加图书请求
     * @data: 2020-07-16-16:50
     * @method: postBook
     * @params: [id]
     * @return: java.lang.String
     */
    @RequestMapping(value = "/pages/book/{bookId}",method = RequestMethod.POST)
    public String postBook(@PathVariable("bookId") String id){
        System.out.println("添加了图书");
        return "success";
    }

}
