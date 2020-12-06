package org.bigjava.bean;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * @ProjectName: JavaEE
 * @ClassName: Employee
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-04 21:21
 * @Version v1.0
 */
public class Employee {
    private String name;
    private String sex;
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", department=" + department +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
