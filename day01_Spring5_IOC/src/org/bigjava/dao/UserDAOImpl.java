package org.bigjava.dao;

import org.springframework.stereotype.Repository;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserDAOImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-02 16:34
 * @Version v1.0
 */
@Repository
public class UserDAOImpl implements UserDAO{
    @Override
    public void update() {
        System.out.println("DAO执行...................");
    }
}
