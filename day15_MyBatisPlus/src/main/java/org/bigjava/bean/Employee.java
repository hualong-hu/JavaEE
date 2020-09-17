package org.bigjava.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @ProjectName: JavaEE
 * @ClassName: Employee
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-13 21:31
 * @Version v1.0
 */
/*
    MyBatis Plus 会默认使用实体类的类名到数据库中找对应的表

 */
//@TableName(value = "tbl_employee")
public class Employee extends Model<Employee> {
    /**
     * @TableId :
     *      value:指定表中的主键列的列名，如果实体属性名和列名一致，可以省略不指定
     *      type：指定主键策略，MySql数据库是：IdType.AUTO
     */
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

//    @TableField(value = "last_name")
    //为该字段指定表名
    private String lastName;

    private String email;
    private Integer gender;
    private Integer age;

    public Employee() {
    }



    public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    /**
     * 指定当前实体类的主键属性
     * @data: 2020-08-15-11:49
     * @method: pkVal
     * @params: []
     * @return: java.io.Serializable
     */
    protected Serializable pkVal() {
        return id;
    }
}
