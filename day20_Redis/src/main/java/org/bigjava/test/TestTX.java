package org.bigjava.test;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestTX
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-22 11:06
 * @Version v1.0
 */
public class TestTX {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "luosheng");

        //开启事务
        Transaction multi = jedis.multi();

        String jsonString = jsonObject.toJSONString();
        //监视数据
        jedis.watch(jsonString);
        try {
            multi.set("user1", jsonString);
            multi.set("user2", jsonString);
            //代码抛出异常，事务执行失败
            int i = 1/0;

            //执行事务
            multi.exec();
        }catch (Exception e){
            //放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            //关闭连接
            jedis.close();
        }


    }


}
