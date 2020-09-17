package org.bigjava.spring5.entity;

/**
 * @ProjectName: JavaEE
 * @ClassName: Book
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-10 23:45
 * @Version v1.0
 */
public class Book {
    private String userId;
    private String username;
    private String ustatus;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }

    public Book(String userId, String username, String ustatus) {
        this.userId = userId;
        this.username = username;
        this.ustatus = ustatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }
}
