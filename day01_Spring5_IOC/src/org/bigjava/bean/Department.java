package org.bigjava.bean;

/**
 * @ProjectName: JavaEE
 * @ClassName: Department
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-04 21:21
 * @Version v1.0
 */
public class Department {

    private String name;
    private int num;

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
