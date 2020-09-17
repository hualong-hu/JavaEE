package org.bigjava.bean;

/**
 * @ProjectName: JavaEE
 * @ClassName: Book
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-02 15:35
 * @Version v1.0
 */
public class Book {
    private String name;
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
