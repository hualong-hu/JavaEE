package org.bigjava.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: CatLifeCycle
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 13:40
 * @Version v1.0
 */
@Component
public class CatLifeCycle implements InitializingBean,DisposableBean {
    public CatLifeCycle(){
        System.out.println("cat创建");
    }


    /**
     * 销毁方法
     * @data: 2020-08-17-13:42
     * @method: destroy
     * @params: []
     * @return: void
     */
    public void destroy() throws Exception {
        System.out.println("cat销毁");
    }
    /**
     * 初始化之后执行的方法
     * @data: 2020-08-17-13:43
     * @method: afterPropertiesSet
     * @params: []
     * @return: void
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat初始化");
    }
}
