package org.bigjava.bean;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: LockDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-02 13:36
 * @Version v1.0
 */
public class Lock {
    private Integer id;
    private String lockName;
    private List<Key> keys;

    public Lock() {
    }

    public Lock(Integer id, String lockName) {
        this.id = id;
        this.lockName = lockName;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", lockName='" + lockName + '\'' +
                ", keys=" + keys +
                '}';
    }
}
