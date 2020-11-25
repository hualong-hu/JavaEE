import org.bigjava.bean.Customer;
import org.bigjava.bean.LinkMan;
import org.bigjava.dao.CustomerDao;
import org.bigjava.dao.LinkManDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: JavaEE
 * @ClassName: OneToMany
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-22 9:29
 * @Version v1.0
 */
//声明spring提供的单元测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring容器的配置信息
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToMany {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    /**
     * 保存一个客户和一个联系人
     *  效果：客户和联系人直接作为独立的数据保存到数据库中，联系人的外键为空
     *  原因：实体类中没有配置关系
     *
     *
     * @data: 2020-10-22-9:34
     * @method: testSave
     * @params: []
     * @return: void
     */
    @Test
    //配置事务
    @Transactional
    //设置不自动回滚
    @Rollback(value = false)
    public void testSave(){
        Customer customer = new Customer(null, "百度", "网络", "SVIP", "IT", "110", "北京");
        LinkMan linkMan = new LinkMan(null, "挽念", "男", "110", "110", "110@qq.com", "程序猿", "挽念");
        /*
         *  配置了客户与联系人的关系
         *      从客户的角度上，发送两条insert语句，发送一条更新语句更新到数据库（更新外键）
         *  由于我们配置了客户到联系人的关系，客户可以对外键进行维护
         */
        customer.getLinkMan().add(linkMan);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    //配置事务
    @Transactional
    //设置不自动回滚
    @Rollback(value = false)
    public void testSave1(){
        Customer customer = new Customer(null, "百度", "网络", "SVIP", "IT", "110", "北京");
        LinkMan linkMan = new LinkMan(null, "洛笙", "男", "110", "110", "110@qq.com", "程序猿", "洛笙");
        /*
         *  配置了联系人到客户的关系（多对一）
         *      只发送了两天insert语句
         *
         *  由于配置了联系人到客户的映射关系（多对一）
         */
        linkMan.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    //配置事务
    @Transactional
    //设置不自动回滚
    @Rollback(value = false)
    public void testSave2(){
        Customer customer = new Customer(null, "百度", "网络", "SVIP", "IT", "110", "北京");
        LinkMan linkMan = new LinkMan(null, "云澈", "男", "110", "110", "110@qq.com", "程序猿", "云澈");

        //由于配置了多的一个到一的一方的关联关系（当保存的时候，就已经对外键赋值）
        linkMan.setCustomer(customer);
        //由于配置了一的一方到多的一方的关联关系（发送一条update语句）
        customer.getLinkMan().add(linkMan);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**
     * 级联添加：保存一个客户的同时，保存客户的所有联系人
     *      需要在操作主体的实体类上，配置cascade属性
     * @data: 2020-10-22-10:59
     * @method: testSave3
     * @params: []
     * @return: void
     */
    @Test
    //配置事务
    @Transactional
    //设置不自动回滚
    @Rollback(value = false)
    public void testSave3(){
        Customer customer = new Customer(null, "百度1", "网络", "SVIP", "IT", "110", "北京");
        LinkMan linkMan = new LinkMan(null, "云澈1", "男", "110", "110", "110@qq.com", "程序猿", "云澈");

        linkMan.setCustomer(customer);
        customer.getLinkMan().add(linkMan);

        customerDao.save(customer);
    }

    /**
     * 级联删除：
     *  删除1号客户的同时，删除1号客户的所有联系人
     * @data: 2020-10-22-11:04
     * @method: testDelete
     * @params: []
     * @return: void
     */
    @Test
    //配置事务
    @Transactional
    //设置不自动回滚
    @Rollback(value = false)
    public void testDelete(){
        Customer customer = customerDao.findOne(1);
        customerDao.delete(customer);
    }
}
