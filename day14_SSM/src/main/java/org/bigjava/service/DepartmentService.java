package org.bigjava.service;

import org.bigjava.bean.Department;
import org.bigjava.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: DepartmentService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-10 21:50
 * @Version v1.0
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepartments(){
        return departmentMapper.selectByExample(null);
    }
}
