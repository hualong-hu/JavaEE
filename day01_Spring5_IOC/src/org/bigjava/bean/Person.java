package org.bigjava.bean;

/**
 * @ProjectName: JavaEE
 * @ClassName: Person
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-02 16:08
 * @Version v1.0
 */
public class Person {
    private String name;
    private int age;
    private double height;
    private String address;
    public Person() {
    }


    public Person(String name, int age, double height, String address) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
