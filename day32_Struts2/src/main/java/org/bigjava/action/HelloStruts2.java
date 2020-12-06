package org.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @ProjectName: JavaEE
 * @ClassName: HelloStruts2
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-02 23:49
 * @Version v1.0
 */
public class HelloStruts2 extends ActionSupport {

    /**
     *  action里面的方法可以没有返回值，没有返回值时候，result标签不需要配置，同时也不会跳转到其他页面
     *   - 把方法写成void
     *   - 让返回值，返回 ”none”
     *
     * @data: 2020-12-04-20:35
     * @method: execute
     * @params: []
     * @return: java.lang.String
     */
    public String execute(){
        System.out.println("------------->execute");
        return "ok";
    }


    public String add(){
        System.out.println("------------->add");
        return NONE;
    }

    public String update(){
        System.out.println("------------->update");
        return NONE;
    }

    public String delete(){
        System.out.println("------------->delete");
        return NONE;
    }
}
