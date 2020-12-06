package org.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.bigjava.bean.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: JavaEE
 * @ClassName: FormTest2
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-04 23:40
 * @Version v1.0
 */
public class FormTest1 extends ActionSupport {
    /**
     * 获取表单数据
     * 第一种方式，使用ActionContext类获取
     * 第二种方式，使用ServletActionContext类,常用
     * 第三种方式，使用接口注入的方式，该类实现 ServletRequestAware 接口（了解即可）
     * @data: 2020-12-05-0:18
     * @method: execute
     * @params: []
     * @return: java.lang.String
     */
    @Override
    public String execute() throws Exception {
        System.out.println("FormTest2.execute");
        //第一种方式，使用ActionContext类获取
//        ActionContext context = ActionContext.getContext();
//        Map<String, Object> map = context.getParameters();
//        Set<String> keySet = map.keySet();
//        for (String key : keySet) {
//            Object[] o = (Object[]) map.get(key);
//            System.out.println(key+"--->"+Arrays.toString(o));
//        }

        //第二种方式，使用ServletActionContext类,常用
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("address = " + address);
        User user = new User(username, password, address);
        System.out.println("user = " + user);
        request.setAttribute("user", user);
        //操作三个域对象（request，session，ServletContext）
//        request.setAttribute("username", username);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("password", password);
//
//        ServletContext servletContext = ServletActionContext.getServletContext();
//        servletContext.setAttribute("address", address);

        //第三种方式，使用接口注入的方式，该类实现 ServletRequestAware 接口（了解即可）

        return SUCCESS;
    }

}
