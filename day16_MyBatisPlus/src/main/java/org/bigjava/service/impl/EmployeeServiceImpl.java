package org.bigjava.service.impl;

import org.bigjava.beans.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.bigjava.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 洛笙
 * @since 2020-08-15
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
