package org.bigjava.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ProjectName: JavaEE
 * @ClassName: ColorFactoryBean
 * @Description: 创建一个Spring定义的FactoryBean
 * @Author: 洛笙
 * @Date: 2020-08-17 13:09
 * @Version v1.0
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...........getObject..........");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }
    /**
     * 控制是否为单例
     * @data: 2020-08-17-13:11
     * @method: isSingleton
     * @params: []
     * @return: boolean
     */
    public boolean isSingleton() {
        return true;
    }
}
