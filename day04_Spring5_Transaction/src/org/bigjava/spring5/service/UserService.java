package org.bigjava.spring5.service;

import org.bigjava.spring5.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-12 16:32
 * @Version v1.0
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired

    private UserDAO userDao;

    public void transfer(){

            //lucy少100
            userDao.reduceMoney();

//            int i = 10 / 0;

            //mary多100
            userDao.addMoney();
    }
}
