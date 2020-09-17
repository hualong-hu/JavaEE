package org.bigjava.spring5.dao;

import org.bigjava.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: BookDAOImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-10 23:37
 * @Version v1.0
 */
@Repository
public class BookDAOImpl implements BookDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into test.t_book values(?,?,?)";
        int update = jdbcTemplate.update(sql,book.getUserId(), book.getUsername(), book.getUstatus());
        System.out.println("受影响的行数是："+update);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update test.t_book set username=?,ustatus=? where user_id=?";
        int update = jdbcTemplate.update(sql, book.getUsername(), book.getUstatus(), book.getUserId());
        System.out.println("受影响的行数是："+update);


    }

    @Override
    public void deleteBook(String id) {
        String sql = "delete from test.t_book where user_id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("受影响的行数是："+update);
    }

    @Override
    public Integer findCount() {
        String sql = "select count(*) from test.t_book";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Book findById(String id) {
        String sql = "select * from test.t_book where user_id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from test.t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void addSome(List<Object[]> list) {
        String sql = "insert into test.t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void updateSome(List<Object[]> list) {
        String sql = "update test.t_book set username=?,ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void deleteSome(List<Object[]> list) {
        String sql = "delete from test.t_book where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }
}
