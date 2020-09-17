package org.bigjava.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bigjava.bean.Department;
import org.springframework.stereotype.Repository;


/**
 * 操作部门
 */
@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "D-AA"));
		departments.put(102, new Department(102, "D-BB"));
		departments.put(103, new Department(103, "D-CC"));
		departments.put(104, new Department(104, "D-DD"));
		departments.put(105, new Department(105, "D-EE"));
	}
	/**
	 * 返回所有的部门
	 * @data: 2020-07-22-18:30
	 * @method: getDepartments
	 * @params: []
	 * @return: java.util.Collection<org.bigjava.bean.Department>
	 */
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	/**
	 * 根据id查询某个部门
	 * @data: 2020-07-22-18:30
	 * @method: getDepartment
	 * @params: [id]
	 * @return: org.bigjava.bean.Department
	 */
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
