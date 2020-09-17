package org.bigjava.controller;

import org.bigjava.bean.Department;
import org.bigjava.bean.Employee;
import org.bigjava.dao.DepartmentDao;
import org.bigjava.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


/**
 * @ProjectName: JavaEE
 * @ClassName: EmployeeController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-23 17:53
 * @Version v1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    /**
     * 查询所有员工
     * @data: 2020-07-23-20:43
     * @method: getEmployees
     * @params: [modelMap]
     * @return: java.lang.String
     */
    @RequestMapping("/employees")
    public String getEmployees(ModelMap modelMap){
        Collection<Employee> allEmployees = employeeDao.getAll();
        modelMap.addAttribute("allEmployees",allEmployees);
        return "employees";
    }
    /**
     * 在前往添加员工页面之前查出所有的部门信息进行展示
     * @data: 2020-07-23-20:43
     * @method: addEmployee
     * @params: [model]
     * @return: java.lang.String
     */
    @RequestMapping("/addEmployee")
    public String addEmployee(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        Employee employee = new Employee();
        model.addAttribute("departments",departments);
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    /**
     * 添加并保持员工
     * @data: 2020-07-23-20:44
     * @method: saveEmployee
     * @params: [employee]
     * @return: java.lang.String
     *
     *
     * 后端校验的步骤
     * 1、导入以下jar包
     *      classmate-0.8.0.jar
     *      hibernate-validator-5.0.0.CR2.jar
     *      hibernate-validator-annotation-processor-5.0.0.CR2.jar
     *      jboss-logging-3.1.1.GA.jar
     *      validation-api-1.1.0.CR1.jar
     * 2、给需要校验的JavaBean的属性添加上校验注解
     * 3、在SpringMVC封装对象的时候，使用@Valid告诉SpringMVC这个javaBean需要校验
     * 4、在需要校验的javaBean后面紧跟一个BindingResult，这个BindingResult就是封装了前一个bean的校验结果
     */
    @RequestMapping(value = "/saveEmployee",method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,Model model){
        //获取是否有校验错误
        boolean errors = result.hasErrors();
        HashMap<String, Object> errorsMap = new HashMap<>();
        if (errors) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误的消息提示："+fieldError.getDefaultMessage());
                System.out.println("错误的字段是："+fieldError.getField());
                System.out.println(fieldError);
                System.out.println("------------------------------");
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAttribute("errorInfo", errorsMap);
            return "addEmployee";
        } else {
            employeeDao.save(employee);
            return "redirect:/employees";
        }
    }

    /**
     * 查询员工,来到修改页面回显
     * @data: 2020-07-24-11:20
     * @method: getEmployee
     * @params: []
     * @return: java.lang.String
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String getEmployee(@PathVariable("id")Integer id , Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "updateEmployee";
    }
    /**
     * 保存修改员工的信息
     * @data: 2020-07-24-15:11
     * @method: updateEmployee
     * @params: [employee]
     * @return: java.lang.String
     */
    @RequestMapping(value = "/updates/{id}",method = RequestMethod.PUT)
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id",required = false) Integer id,Model model){
        if (id!=null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee", employee);
        }
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
    }

    @RequestMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employees";
    }


}
