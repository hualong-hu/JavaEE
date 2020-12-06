package org.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.bigjava.bean.User;


import javax.servlet.http.HttpServletRequest;


/**
 * 模型驱动封装：
 * 1、实现ModelDriven接口
 * 2、重写接口中的方法
 * 3、new一个实体类对象
 * @ProjectName: JavaEE
 * @ClassName: FormTest2
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-04 23:40
 * @Version v1.0
 */
public class FormTest2 extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("FormTest2.execute");
        System.out.println("user = " + user);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("user", user);
        return SUCCESS;
    }
}
