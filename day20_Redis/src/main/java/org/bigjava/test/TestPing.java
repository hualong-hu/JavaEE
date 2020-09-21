package org.bigjava.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestPing
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-21 14:45
 * @Version v1.0
 */
public class TestPing {

    public static void main(String[] args) {
        //1、new Jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //jedis所有的命令都是我们之前学习的所有指令
        System.out.println(jedis.ping());
    }
}