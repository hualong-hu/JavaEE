package org.bigjava.dao;

import org.bigjava.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ProjectName: JavaEE
 * @ClassName: CustomerDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-20 23:35
 * @Version v1.0
 */
public interface CustomerDao extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {

}
