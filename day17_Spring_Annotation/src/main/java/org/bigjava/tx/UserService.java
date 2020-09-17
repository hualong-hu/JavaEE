package org.bigjava.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 16:59
 * @Version v1.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insertUser(){
        userMapper.insert();
        System.out.println("插入成功");
    }
}
