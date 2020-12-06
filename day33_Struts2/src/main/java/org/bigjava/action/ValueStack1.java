package org.bigjava.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @ProjectName: JavaEE
 * @ClassName: ValueStack1
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-05 23:02
 * @Version v1.0
 */
public class ValueStack1 extends ActionSupport {

    private String name;

    public String getName() {
        return name;
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
        //第一种 获取值栈对象，调用值栈对象里面的 set 方法
//        ActionContext context = ActionContext.getContext();
//        ValueStack valueStack = context.getValueStack();
//        valueStack.set("username", "洛笙");
//        //第二种 获取值栈对象，调用值栈对象里面的  push方法
//        valueStack.push("123456");

        //第三种 在action定义变量，生成变量的get方法
        name = "洛笙";

        return SUCCESS;
    }
}
