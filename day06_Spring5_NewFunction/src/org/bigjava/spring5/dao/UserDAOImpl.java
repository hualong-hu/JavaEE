package org.bigjava.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserDAOImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-12 16:32
 * @Version v1.0
 */
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void reduceMoney() {
        String sql = "update test.t_account set money=money-? where username=?";
        int update = jdbcTemplate.update(sql, 100, "lucy");
        System.out.println("受影响的行数为："+update);
    }

    @Override
    public void addMoney() {
        String sql = "update test.t_account set money=money+? where username=?";
        int update = jdbcTemplate.update(sql, 100, "mary");
        System.out.println("受影响的行数为："+update);
    }
}
