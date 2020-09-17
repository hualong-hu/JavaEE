package org.bigjava.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestGenerate
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-15 13:11
 * @Version v1.0
 */
public class TestGenerate {
    /**
     * 代码生成器
     * @data: 2020-08-15-13:11
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void testGenerate(){
        //1、设置全局配置
        GlobalConfig config = new GlobalConfig();
        //设置是否支持AR模式
        config.setActiveRecord(true);
        //设置作者
        config.setAuthor("洛笙");
        //设置生成路径
        config.setOutputDir("C:\\Users\\洛笙\\IdeaProjects\\JavaEE\\day16_MyBatisPlus\\src\\main\\java");
        //设置文件是否覆盖
        config.setFileOverride(true);
        //设置主键策略
        config.setIdType(IdType.AUTO);
        //设置生成的service接口的名字的首字母是否为I
        config.setServiceName("%sService");
        //XML ResultMap
        config.setBaseResultMap(true);
        //XML columList
        config.setBaseColumnList(true);

        //2、数据源配置
        DataSourceConfig sourceConfig = new DataSourceConfig();
        //设置数据库类型
        sourceConfig.setDbType(DbType.MYSQL);
        sourceConfig.setDriverName("com.mysql.jdbc.Driver");
        sourceConfig.setUsername("root");
        sourceConfig.setPassword("123456");
        sourceConfig.setUrl("jdbc:mysql://localhost:3306/test");

        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //设置全局大写命名
        strategyConfig.setCapitalMode(true);
        //设置指定表名 字段名是否使用下划线
        strategyConfig.setDbColumnUnderline(true);
        //数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //指定数据库表前缀
        strategyConfig.setTablePrefix("tbl_");
        //指定需要生成的表
        strategyConfig.setInclude("tbl_employee");

        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("org.bigjava");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        packageConfig.setEntity("beans");
        packageConfig.setXml("mapper");

        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config);
        autoGenerator.setDataSource(sourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);

        //6、执行
        autoGenerator.execute();

        /**
         *
         *
         */
    }
}
