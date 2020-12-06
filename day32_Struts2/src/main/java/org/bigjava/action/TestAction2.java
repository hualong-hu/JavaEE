package org.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestAction1
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-12-04 23:08
 * @Version v1.0
 */
public class TestAction2 extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("TestAction2.execute");
        return SUCCESS;
    }
}
