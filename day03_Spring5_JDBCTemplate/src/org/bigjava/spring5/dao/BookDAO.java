package org.bigjava.spring5.dao;

import org.bigjava.spring5.entity.Book;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: BookDAO
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-10 23:36
 * @Version v1.0
 */
public interface BookDAO {
    /**
     * 添加的接口
     * @data: 2020-07-10-23:56
     * @method: add
     * @params: [book]
     * @return: void
     */
    void add(Book book);

    void updateBook(Book book);

    void deleteBook(String id);

    Integer findCount();

    Book findById(String id);

    List<Book> findAll();

    void addSome(List<Object[]> list);

    void updateSome(List<Object[]> list);

    void deleteSome(List<Object[]> list);
}
