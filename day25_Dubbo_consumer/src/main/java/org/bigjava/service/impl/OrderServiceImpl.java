package org.bigjava.service.impl;



import bigjava.bean.UserAddress;
import bigjava.service.OrderService;
import bigjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、将服务提供者注册到注册中心
 *      1）、导入dubbo依赖 \ 操作zookeeper的客户端
 *      2）、配置服务提供者
 * 2、让服提供者去注册中心订阅服务提供者的服务地址
 * @ProjectName: JavaEE
 * @ClassName: OrderServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-03 10:20
 * @Version v1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    public void initOrder(String userId) {
        System.out.println("用户id ："+userId);
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println("userAddress = " + userAddress.getUserAddress());
        }
    }
}
