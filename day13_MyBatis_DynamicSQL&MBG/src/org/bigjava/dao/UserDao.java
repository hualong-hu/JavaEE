package org.bigjava.dao;

import org.apache.ibatis.annotations.Param;
import org.bigjava.bean.User;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-04 16:58
 * @Version v1.0
 */
public interface UserDao {

    User getUserById(Integer id);

    List<User> getAllUsers(User user);

    List<User> getUsersForeach(@Param("ids")List<Integer> ids);

    List<User> getUsersChoose(User user);

    int updateUser(User user);
}
