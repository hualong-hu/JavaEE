package org.bigjava.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserMapper
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 16:58
 * @Version v1.0
 */
@Repository
public class UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into test.user (name,password,address,phone) values (?,?,?,?)";
        jdbcTemplate.update(sql, "断念","123456","江西","110");
    }

}
