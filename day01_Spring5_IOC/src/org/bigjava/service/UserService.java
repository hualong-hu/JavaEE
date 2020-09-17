package org.bigjava.service;

import org.bigjava.dao.UserDAO;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-02 16:35
 * @Version v1.0
 */
public class UserService {

    private UserDAO userDao;

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public void show(){
        System.out.println("service执行....................");
        userDao.update();
    }
}
