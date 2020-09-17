package org.bigjava.dao;

import org.bigjava.bean.Employee;

/**
 * @ProjectName: JavaEE
 * @ClassName: EmployeeDAO
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-29 11:03
 * @Version v1.0
 */
public interface EmployeeDAO {
    /**
     * 通过id查询员工
     * @data: 2020-07-29-11:04
     * @method: getEmployeeById
     * @params: [id]
     * @return: org.bigjava.bean.Employee
     */
    Employee getEmployeeById(Integer id);
    /**
     * 增加员工
     * @data: 2020-07-29-19:00
     * @method: insertEmployee
     * @params: [employee]
     * @return: int
     */
    int insertEmployee(Employee employee);
    /**
     * 通过id删除员工
     * @data: 2020-07-29-19:00
     * @method: deleteEmployee
     * @params: [id]
     * @return: int
     */
    int deleteEmployee(Integer id);

    /**
     * 修改员工信息
     * @data: 2020-07-29-19:01
     * @method: updateEmployee
     * @params: [employee] 员工对象
     * @return: int
     */
    int updateEmployee(Employee employee);
}
