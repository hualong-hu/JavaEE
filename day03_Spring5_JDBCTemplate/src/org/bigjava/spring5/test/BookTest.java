package org.bigjava.spring5.test;
import java.util.ArrayList;
import java.util.List;

import org.bigjava.spring5.entity.Book;
import org.bigjava.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: BookTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-11 0:01
 * @Version v1.0
 */
public class BookTest {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("bean1.xml");
    private BookService bookService = ctx.getBean("bookService", BookService.class);
    @Test
    public void test1() {
        bookService.add(new Book("4", "MySql", "c"));
    }
    @Test
    public void test2() {
        bookService.updateBook(new Book("1", "JS", "A"));
    }
    @Test
    public void test3() {
        bookService.deleteBook("1");
    }

    @Test
    public void test4() {
        Integer count = bookService.findCount();
        System.out.println("表中共有"+count+"条记录");
    }
    @Test
    public void test5() {
        Book book = bookService.findById("2");
        System.out.println("book = " + book);
    }
    @Test
    public void test6() {
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            System.out.println("book = " + book);
        }
    }
    @Test
    public void test7() {
        List<Object[]> list = new ArrayList<>();
        Object[] o1 = {"5","PHP","d"};
        Object[] o2 = {"6","Spring5","e"};
        Object[] o3 = {"7","Html","f"};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        bookService.addSome(list);
    }
    @Test
    public void test8(){
        List<Object[]> list = new ArrayList<>();
        Object[] o1 = {"PHP","x","5"};
        Object[] o2 = {"Spring5","y","6"};
        Object[] o3 = {"Html","z","7"};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        bookService.updateSome(list);
    }
    @Test
    public void test(){
        List<Object[]> list = new ArrayList<>();
        Object[] o1 = {"5"};
        Object[] o2 = {"6"};
        Object[] o3 = {"7"};
        list.add(o1);
        list.add(o2);
        list.add(o3);
        bookService.deleteSome(list);
    }
}
