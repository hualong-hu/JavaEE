package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-19 14:47
 * @Version v1.0
 */
@Controller
public class TestController {

    @RequestMapping(value="/test1")
    public String  test(){
        return "success";
    }
}
