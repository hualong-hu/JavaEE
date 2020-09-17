package org.bigjava.controller;

import org.bigjava.bean.Employee;
import org.bigjava.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collection;

/**
 * @ProjectName: JavaEE
 * @ClassName: AjaxTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-26 17:14
 * @Version v1.0
 */
@Controller
public class AjaxTest {
    @Autowired
    EmployeeDao employeeDao;

    /**
     *
     * @data: 2020-07-26-17:16
     * @method: ajaxGetAll
     * @params: []
     * @return: java.util.Collection<org.bigjava.bean.Employee>
     *
     * @ResponseBody 将返回的数据放在响应体中，如果是对象，jackson包自动将对象转成json格式
     *
     *
     */
    @ResponseBody
    @RequestMapping(value="/getAll")
    public Collection<Employee>  testResponseBody(){
        return employeeDao.getAll();
    }
    //${pageContext.request.contextPath}
    /**
     *
     * @data: 2020-07-27-10:53
     * @method: testRequestBody
     * @params: []
     * @return: java.lang.String
     *
     * @RequestBody 获取一个请求的请求体
     * @RequestParam 获取请求参数
     * @ResponseBody 获取json数据
     * @RequestBody 返回json数据
     * HttpEntity<String> string : 获取一个请求的请求体和请求头
     */
    @RequestMapping(value="/testRequestBody")
    public String  testRequestBody(@RequestBody String body, Model model){
        System.out.println("body = " + body);
        model.addAttribute("body", body);
        return "success";
    }
    @RequestMapping(value="/testRequestBody1")
    public String  testRequestBody1(@RequestBody String body, Employee employee){
        System.out.println("employee = " + employee);

        return "success";
    }
}
