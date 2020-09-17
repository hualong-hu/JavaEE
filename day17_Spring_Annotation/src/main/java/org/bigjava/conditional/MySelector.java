package org.bigjava.conditional;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ProjectName: JavaEE
 * @ClassName: MySelector
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 18:13
 * @Version v1.0
 * 自定义逻辑返回需要导入的组件
 */
public class MySelector implements ImportSelector {

    /**
     * 返回值，就是导入到容器中的组件全类名
     * AnnotationMetadata：当前标注@Import注解的类的所有注解信息
     * @data: 2020-08-16-18:18
     * @method: selectImports
     * @params: [importingClassMetadata]
     * @return: java.lang.String[]
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"org.bigjava.bean.Yellow","org.bigjava.bean.Blue"};
    }
}
