package org.bigjava.bean;
import	java.lang.Double;

/**
 * @ProjectName: JavaEE
 * @ClassName: Book
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-20 17:47
 * @Version v1.0
 */
public class Book {
    private String bookName;
    private String author;
    private Double price;
    private Integer stock;
    private Integer sales;

    public Book() {
    }

    public Book(String bookName, String author, Double price, Integer stock, Integer sales) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
