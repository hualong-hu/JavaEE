package org.bigjava.bean;

/**
 * @ProjectName: JavaEE
 * @ClassName: User
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-05 0:13
 * @Version v1.0
 */
public class User {

    private String username;
    private String password;
    private String address;

    public User() {
    }

    public User(String username, String password, String address) {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
