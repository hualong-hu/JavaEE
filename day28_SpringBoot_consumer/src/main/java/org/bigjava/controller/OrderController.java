package org.bigjava.controller;

import bigjava.bean.UserAddress;
import bigjava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-03 20:38
 * @Version v1.0
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value="/initOrder")
    public List<UserAddress>  initOrder(@RequestParam("uid") String userId){
        List<UserAddress> list = orderService.initOrder(userId);
        return list;
    }

}
