package org.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.bigjava.bean.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 表达式封装
 * 第一步 在action里面声明实体类
 * 第二步 生成实体类变量的set和get方法
 * 第三步 在表单输入项的name属性值里面写表达式形式
 * @ProjectName: JavaEE
 * @ClassName: FormTest2
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-04 23:40
 * @Version v1.0
 */
public class FormTest3 extends ActionSupport{

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("FormTest3.execute");
        System.out.println("user = " + user);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("user", user);
        return SUCCESS;
    }
}
