package org.bigjava.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是windows系统
 * @ProjectName: JavaEE
 * @ClassName: WindowsConditional
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 16:44
 * @Version v1.0
 */
public class WindowsConditional implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")){
            return true;
        }
        return false;
    }
}
