package org.bigjava.bean;

/**
 * @ProjectName: JavaEE
 * @ClassName: Employee
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-29 11:00
 * @Version v1.0
 */
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Integer myAge;
    private String myHobby;

    public Employee() {
    }

    public Employee(Integer id, String name, String email, Integer gender, Integer myAge, String myHobby) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.myAge = myAge;
        this.myHobby = myHobby;
    }

    public Employee(Integer id, String name, String email, Integer gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", myAge=" + myAge +
                ", myHobby='" + myHobby + '\'' +
                '}';
    }

    public Integer getMyAge() {
        return myAge;
    }

    public void setMyAge(Integer myAge) {
        this.myAge = myAge;
    }

    public String getMyHobby() {
        return myHobby;
    }

    public void setMyHobby(String myHobby) {
        this.myHobby = myHobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
