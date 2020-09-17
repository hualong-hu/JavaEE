package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

/**
 * @ProjectName: JavaEE
 * @ClassName: AsyncController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-19 16:45
 * @Version v1.0
 */
@Controller
public class AsyncController {

    /**
     * 1、控制器返回Callable
     * 2、Spring异步处理，将Callable提交到TaskExecutor 使用一个隔离的线程进行执行
     * 3、DispatchServlet和所有的Filter退出web容器的线程，但是response保持打开状态
     * 4、Callable返回结果，SpringMVC将请求重新派发给容器，恢复之前的处理
     * 5、根据Callable返回的结果，Spring继续进行视图渲染流程等（从接收请求--视图渲染）
     * @data: 2020-08-19-16:55
     * @method: async01
     * @params: []
     * @return: java.util.concurrent.Callable<java.lang.String>
     */
    @ResponseBody
    @RequestMapping(value="/async01")
    public Callable<String> async01(){
        System.out.println("主线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("副线程结束..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
                return "Callable<String> async01";
            }
        };

        System.out.println("主线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());

        return callable;
    }
}
