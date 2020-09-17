package org.bigjava.dao;

import org.apache.ibatis.annotations.Param;
import org.bigjava.bean.Employee;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: EmployeeDAO
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-29 11:03
 * @Version v1.0
 */
public interface EmployeeDAO {

    Employee getEmployeeById(Integer id);

    Employee getEmployeeByIdAndName(@Param("id")Integer id,@Param("name")String name);

    List<Employee> getAllEmployees();

    List<Employee> getAllEmployeesResultMap();

    int insertEmployee(Employee employee);

    int deleteEmployee(Integer id);

    int updateEmployee(Employee employee);
}
