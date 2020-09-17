package org.bigjava.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * 自定义全局操作
 * @ProjectName: JavaEE
 * @ClassName: MySqlInjector
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-15 17:50
 * @Version v1.0
 */
public class MySqlInjector extends AutoSqlInjector {
    /**
     * 扩展inject方法，完成自定义全局操作
     * @data: 2020-08-15-18:05
     * @method: inject
     * @params: [configuration, builderAssistant, mapperClass, modelClass, table]
     * @return: void
     */
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        super.inject(configuration, builderAssistant, mapperClass, modelClass, table);

        //注入的SQL语句
        String sql = "delete from" + table.getTableName();

        //注入方法名，一定要与EmployeeMapper接口中的方法一直
        String method = "deleteAll";

        //构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        //构造一个删除的MappedStatement
        this.addDeleteMappedStatement(mapperClass, method, sqlSource);


    }
}
