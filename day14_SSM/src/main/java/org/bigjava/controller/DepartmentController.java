package org.bigjava.controller;

import org.bigjava.bean.Department;
import org.bigjava.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


/**
 * @ProjectName: JavaEE
 * @ClassName: DepartmentController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-10 21:49
 * @Version v1.0
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    @RequestMapping(value="/department")
    @ResponseBody
    public List<Department>  showDepartment(){
        return departmentService.getDepartments();
    }
}
