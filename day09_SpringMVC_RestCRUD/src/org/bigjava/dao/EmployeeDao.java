package org.bigjava.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bigjava.bean.Department;
import org.bigjava.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 操作员工
 */
@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
	}
	/**
	 * 初始ID
	 */
	private static Integer initId = 1006;
	/**
	 * 员工保存和更新二合一方法
	 * @data: 2020-07-22-18:27
	 * @method: save
	 * @params: [employee]
	 * @return: void
	 */
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		//根据部门id单独查出部门信息设置到员工对象中，页面只需要提交部门的id
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	/**
	 * 查询所有员工
	 * @data: 2020-07-22-18:29
	 * @method: getAll
	 * @params: []
	 * @return: java.util.Collection<org.bigjava.bean.Employee>
	 */
	public Collection<Employee> getAll(){
		return employees.values();
	}
	/**
	 * 通过id查询某个员工的信息
	 * @data: 2020-07-22-18:29
	 * @method: get
	 * @params: [id]
	 * @return: org.bigjava.bean.Employee
	 */
	public Employee get(Integer id){
		return employees.get(id);
	}
	/**
	 * 根据id删除某个员工的信息
	 * @data: 2020-07-22-18:29
	 * @method: delete
	 * @params: [id]
	 * @return: void
	 */
	public void delete(Integer id){
		employees.remove(id);
	}
}
