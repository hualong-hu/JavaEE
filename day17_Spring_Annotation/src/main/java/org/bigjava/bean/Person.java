package org.bigjava.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ProjectName: JavaEE
 * @ClassName: Person
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 12:39
 * @Version v1.0
 */
public class Person {
    /*
        @Value赋值：
            1、基本数值
            2、可以写SqEl：#{}
            3、可以写${},取出配置文件【properties】中的值（在运行环境变量里面的值）
     */
    @Value("云澈")
    private String name;

    @Value("#{20+30}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Person(String name, Integer age, String nickName) {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
