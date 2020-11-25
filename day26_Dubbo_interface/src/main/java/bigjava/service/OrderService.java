package bigjava.service;

import bigjava.bean.UserAddress;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: OrderService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-03 10:19
 * @Version v1.0
 */
public interface OrderService {
    /**
     * 初始化订单
     * @data: 2020-11-03-10:20
     * @method: initOrder
     * @params: [userId]
     * @return: void
     */
    public List<UserAddress> initOrder(String userId);
}
