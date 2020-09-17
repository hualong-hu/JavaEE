package org.bigjava.dao;

import org.bigjava.bean.Key;

/**
 * @ProjectName: JavaEE
 * @ClassName: KeyDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-02 14:05
 * @Version v1.0
 */
public interface KeyDao {

    Key getKeyById(Integer id);
}
