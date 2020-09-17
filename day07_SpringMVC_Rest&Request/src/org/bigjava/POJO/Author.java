package org.bigjava.POJO;

/**
 * @ProjectName: JavaEE
 * @ClassName: Author
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-17 16:57
 * @Version v1.0
 */
public class Author {
    private String phone;
    private String email;
    private Integer age;

    public Author() {
    }

    public Author(String phone, String email, Integer age) {
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
