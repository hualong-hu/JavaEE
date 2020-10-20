package org.bigjava.dao;

import org.bigjava.bean.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ProjectName: JavaEE
 * @ClassName: LinkManDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-20 23:35
 * @Version v1.0
 */
public interface LinkManDao extends JpaRepository<LinkMan,Integer>, JpaSpecificationExecutor<LinkMan> {

}
