package org.bigjava.mapper;

import org.bigjava.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 洛笙
 * @since 2020-08-15
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    int deleteAll(Integer id);
}
