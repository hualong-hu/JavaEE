package org.bigjava.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.bigjava.bean.Employee;
import org.springframework.stereotype.Service;


/**
 * @ProjectName: JavaEE
 * @ClassName: EmployeeMapper
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-14 10:17
 * @Version v1.0
 * 基于MyBatis：在mapper接口编写CRUD相关的方法，提供Mapper接口所对应的SQL映射文件以及方法对应的SQL查询
 *
 * 基于MyBatis Plus：让xxxMapper接口继承BaseMapper接口即可
 *                  BaseMapper<T>：泛型指定的就是当前Mapper接口所操作的实体类类型
 *
 *
 */
@Service
public interface EmployeeMapper extends BaseMapper<Employee> {

}
