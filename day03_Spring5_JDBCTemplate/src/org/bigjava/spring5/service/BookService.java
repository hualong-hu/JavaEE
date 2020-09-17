package org.bigjava.spring5.service;
import	java.util.List;

import org.bigjava.spring5.dao.BookDAO;
import org.bigjava.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: JavaEE
 * @ClassName: BookService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-10 23:37
 * @Version v1.0
 */
@Service
public class BookService {
    //注入dao

    @Autowired
    private BookDAO bookDAO;

    /**
     * 添加的方法
     * @data: 2020-07-10-23:55
     * @method: add
     * @params: [book]
     * @return: void
     */
    public void add(Book book){
        bookDAO.add(book);
    }

    public void updateBook(Book book){
        bookDAO.updateBook(book);
    }

    public void deleteBook(String id){
        bookDAO.deleteBook(id);
    }

    public Integer findCount(){
       return bookDAO.findCount();
    }

    public Book findById(String id){
        return bookDAO.findById(id);
    }

    public List<Book> findAll(){
        return bookDAO.findAll();
    }

    public void addSome(List<Object[]> list){
        bookDAO.addSome(list);
    }

    public void updateSome(List<Object[]> list){
        bookDAO.updateSome(list);
    }

    public void deleteSome(List<Object[]> list){
        bookDAO.deleteSome(list);
    }
}
