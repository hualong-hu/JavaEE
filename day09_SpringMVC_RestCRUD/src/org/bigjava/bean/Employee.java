package org.bigjava.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class Employee {

	private Integer id;

	@NotEmpty
	@Length(max = 18,min = 4)
	private String lastName;

	@Email
	private String email;
	/**
	 * 1 male, 0 female
	 */
	@NotNull
	private Integer gender;

	@JsonIgnore
	private Department department;

	/**
	 * @DateTimeFormat (pattern = "yyyy-MM-dd") 规定页面提交的日期格式
	 * @Past 必须是过去的时间
	 * @Future 必须是未来的时间
	 * @JsonFormat (pattern = "yyyy-MM-dd") 将时间戳转换成规定的日期格式，以json返回页面
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth = new Date();

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;

	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", department=" + department +
				", birth=" + birth +
				'}';
	}
}
