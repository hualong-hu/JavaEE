package org.bigjava.service;

import org.bigjava.bean.Employee;
import org.bigjava.bean.EmployeeExample;
import org.bigjava.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: EmployeeService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-09 15:25
 * @Version v1.0
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    /**
     * 查询所有员工
     * @data: 2020-08-09-15:26
     * @method: getAll
     * @params: []
     * @return: java.util.List<org.bigjava.bean.Employee>
     */
    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDepartment(null);
    }

    public void save(Employee employee){
         employeeMapper.insertSelective(employee);
    }

    public Employee getEmployeeById(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    public void updateEmployee(Employee employee){
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmployee(Integer id){
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids){
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeIdIn(ids);
        employeeMapper.deleteByExample(example);
    }

    public void deleteAll(){
        employeeMapper.deleteAll();
    }

}
