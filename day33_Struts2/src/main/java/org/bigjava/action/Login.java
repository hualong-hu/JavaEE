package org.bigjava.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: JavaEE
 * @ClassName: Login
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-06 11:43
 * @Version v1.0
 */
public class Login extends ActionSupport {


    public String login() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("password = " + password);
        int i = 10/0;
        request.getSession().invalidate();
        if ("洛笙".equals(username) && "123456".equals(password)){
            request.getSession().setAttribute("username", username);
            return SUCCESS;
        }else {
            request.setAttribute("msg", "登录失败！密码或用户名错误！");
            return ERROR;
        }
    }

    public String test(){
        System.out.println("1111111111111111111");
        return SUCCESS;

    }


}
