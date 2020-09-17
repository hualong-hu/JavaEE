package org.bigjava.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.bigjava.bean.Employee;
import org.bigjava.bean.Msg;
import org.bigjava.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: EmployeeController
 * @Description: 处理员工增删改查
 * @Author: 洛笙
 * @Date: 2020-08-09 15:23
 * @Version v1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * 查询所有员工，并进行分页
     * @data: 2020-08-13-0:44
     * @method: showEmployees
     * @params: [pageNum, model]
     * @return: java.lang.String
     */
    @RequestMapping(value="/employees")
    public String  showEmployees(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
    , Model model){
        //第一个参数是页码，第二个参数是每页的大小
        PageHelper.startPage(pageNum, 6);
        //startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> employeeList = employeeService.getAll();
        //使用pageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        //第一个参数是查询的结果，第二个参数是连续显示的页数
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }
    /**
     * 添加员工
     * @data: 2020-08-13-0:44
     * @method: addEmployee
     * @params: [employee, result]
     * @return: org.bigjava.bean.Msg
     */
    @ResponseBody
    @RequestMapping(value="/employees",method = RequestMethod.POST)
    public Msg addEmployee(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            //校验失败，返回失败信息，在模态框中显示校验失败的错误信息
            HashMap<String, Object> map = new HashMap<>();
            //获取所有的错误信息
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误的信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else {
            employeeService.save(employee);
            return Msg.success();
        }
    }
/**
 * 通过id查询某个员工
 * @data: 2020-08-13-0:44
 * @method: getEmployeeById
 * @params: [id]
 * @return: org.bigjava.bean.Msg
 */
    @ResponseBody
    @RequestMapping(value = "/employees/{id}",method = RequestMethod.GET)
    public Msg getEmployeeById(@PathVariable("id")Integer id){
        Employee employee = employeeService.getEmployeeById(id);
//        System.out.println(employee);
        return Msg.success().add("employee", employee);
    }

    /**
     * 员工信息更新
     * @data: 2020-08-12-15:13
     * @method: updateEmployee
     * @params: [employee]
     * @return: org.bigjava.bean.Msg
     */
    @ResponseBody
    @RequestMapping(value = "/employees/{employeeId}",method = RequestMethod.PUT)
    public Msg updateEmployee(Employee employee){
//        System.out.println(employee);
        employeeService.updateEmployee(employee);
        return Msg.success();
    }

    /**
     * 批量删除与单个删除
     * @data: 2020-08-13-0:07
     * @method: deleteEmployee
     * @params: [id]
     * @return: org.bigjava.bean.Msg
     */
    @ResponseBody
    @RequestMapping(value = "/employees/{ids}",method = RequestMethod.DELETE)
    public Msg deleteEmployee(@PathVariable("ids")String ids){
        if (ids.contains("-")){
            ArrayList<Integer> list = new ArrayList<>();
            String[] split = ids.split("-");
            for (String s : split) {
                list.add(Integer.parseInt(s));
            }
            employeeService.deleteBatch(list);
        }else {
            employeeService.deleteEmployee(Integer.parseInt(ids));
        }
        return Msg.success();
    }
    /**
     * 清除所有数据！
     * @data: 2020-08-13-0:43
     * @method: deleteAll
     * @params: []
     * @return: org.bigjava.bean.Msg
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll")
    public Msg deleteAll(){
        employeeService.deleteAll();
        return Msg.success();
    }
}
