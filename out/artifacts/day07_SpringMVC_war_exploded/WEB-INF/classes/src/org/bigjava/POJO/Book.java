package org.bigjava.POJO;

/**
 * @ProjectName: JavaEE
 * @ClassName: Book
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-17 16:57
 * @Version v1.0
 */
public class Book {
    private String authorName;
    private String bookName;
    private Double price;
    private Author author;

    public Book() {
    }

    public Book(String authorName, String bookName, Double price, Author author) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
