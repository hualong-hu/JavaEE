package org.bigjava.dao;

import org.bigjava.bean.Lock;

/**
 * @ProjectName: JavaEE
 * @ClassName: LockDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-02 18:28
 * @Version v1.0
 */
public interface LockDao {

    Lock getLockById(Integer id);
    Lock getLockByIdSimpl(Integer id);
}
