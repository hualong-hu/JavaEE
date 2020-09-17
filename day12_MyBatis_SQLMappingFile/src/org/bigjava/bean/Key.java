package org.bigjava.bean;

/**
 * @ProjectName: JavaEE
 * @ClassName: Key
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-02 13:35
 * @Version v1.0
 */
public class Key {

    private Integer id;
    private String keyName;
    private Lock lock;

    public Key() {
    }

    public Key(Integer id, String keyName, Lock lock) {
        this.id = id;
        this.keyName = keyName;
        this.lock = lock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", keyName='" + keyName + '\'' +
                ", lock=" + lock +
                '}';
    }
}
