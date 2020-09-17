package org.bigjava.metaobjecthandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @ProjectName: JavaEE
 * @ClassName: MetaObjectHandle
 * @Description: 自定义公共字段填充处理器
 * @Author: 洛笙
 * @Date: 2020-08-15 18:30
 * @Version v1.0
 */
public class MetaObjectHandle extends MetaObjectHandler {
    /**
     * 插入操作  自动填充
     * @data: 2020-08-15-18:33
     * @method: insertFill
     * @params: [metaObject]
     * @return: void
     */
    public void insertFill(MetaObject metaObject) {
        //1、获取到需要被填充的字段的值
        Object fieldValByName = getFieldValByName("email", metaObject);

        if (fieldValByName == null){
            System.out.println("===============插入操作满足填充条件===============");
            setFieldValByName("email", "666@qq.com", metaObject);
        }


    }

    /**
     * 修改操作  自动填充
     * @data: 2020-08-15-18:34
     * @method: updateFill
     * @params: [metaObject]
     * @return: void
     */
    public void updateFill(MetaObject metaObject) {
        Object fieldValByName = getFieldValByName("email", metaObject);

        if (fieldValByName == null){
            System.out.println("===============修改操作满足填充条件===============");
            setFieldValByName("email", "777@qq.com", metaObject);
        }
    }
}
