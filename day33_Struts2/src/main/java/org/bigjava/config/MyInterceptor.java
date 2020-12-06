package org.bigjava.config;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyInterceptor
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-06 11:45
 * @Version v1.0
 */
public class MyInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if (username != null){
            //登录状态
            //类似于放行操作，执行action方法
            return actionInvocation.invoke();
        }else {
            //不是登录状态
            //不执行action，返回登录页面
            //到result标签找名称是error的值，到配置路径里面
            request.setAttribute("msg", "请先登录！！");
            return "error";
        }


    }
}
