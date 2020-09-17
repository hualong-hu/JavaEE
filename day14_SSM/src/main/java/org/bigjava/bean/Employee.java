package org.bigjava.bean;

public class Employee {
    private Integer employeeId;

    private String employeeName;

    private String gender;

    private String email;

    private Integer salary;

    private Integer departmentId;

    private Department department;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String gender, String email, Integer salary, Integer departmentId, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.departmentId = departmentId;
        this.department = department;
    }

    public Employee(Integer employeeId, String employeeName, String gender, String email, Integer salary, Integer departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", department=" + department +
                '}';
    }
}