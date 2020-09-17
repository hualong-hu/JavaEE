package org.bigjava.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bigjava.bean.Employee;

/**
 * @ProjectName: JavaEE
 * @ClassName: EmployeeDaoAnnotation
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-30 17:01
 * @Version v1.0
 */
public interface EmployeeDaoAnnotation {
    @Select("select * from mybatis_0228.t_employee where id = #{id}")
    Employee getEmployeeById(Integer id);
    @Insert("insert into mybatis_0228.t_employee(name, gender, email)" +
            " values (#{name},#{gender},#{email})")
    int insertEmployee(Employee employee);

    @Delete("delete from mybatis_0228.t_employee where id = #{id}")
    int deleteEmployee(Integer id);

    @Update("update mybatis_0228.t_employee set name=#{name},gender=#{gender},email=#{email}" +
            " where id=#{id}")
    int updateEmployee(Employee employee);
}
