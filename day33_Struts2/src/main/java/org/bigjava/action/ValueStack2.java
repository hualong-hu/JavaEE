package org.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;
import org.bigjava.bean.User;

import java.util.ArrayList;

/**
 * @ProjectName: JavaEE
 * @ClassName: ValueStack1
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-05 23:02
 * @Version v1.0
 */
public class ValueStack2 extends ActionSupport {

//    private User user = new User();
//    public User getUser() {
//        return user;
//    }
    private ArrayList<User> list = new ArrayList<>();
    public ArrayList<User> getList() {
        return list;
    }

    /**
     * 向值栈中存取数据
     * @data: 2020-12-05-23:22
     * @method: execute
     * @params: []
     * @return: java.lang.String
     */
    @Override
    public String execute() throws Exception {
//        user = new User("洛笙", "123456", "南昌");
        User user1 = new User("洛笙", "123456", "南昌");
        User user2 = new User("溪苏", "123456", "南昌");
        list.add(user1);
        list.add(user2);


        return SUCCESS;
    }
}
