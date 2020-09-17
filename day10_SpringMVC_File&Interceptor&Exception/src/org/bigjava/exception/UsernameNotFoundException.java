package org.bigjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ProjectName: JavaEE
 * @ClassName: UsernameNotFoundException
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-28 17:57
 * @Version v1.0
 */
@ResponseStatus(reason = "登录请求被拒绝",value = HttpStatus.NOT_ACCEPTABLE)
public class UsernameNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 9L;

}
