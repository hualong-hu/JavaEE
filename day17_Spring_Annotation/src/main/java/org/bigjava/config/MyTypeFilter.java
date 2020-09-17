package org.bigjava.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyTypeFilter
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 13:24
 * @Version v1.0
 */

public class MyTypeFilter implements TypeFilter {
    /**
     * metadataReader：读取到当前正在扫描的类的信息
     * metadataReaderFactory：可以获取到其他任何类信息
     * @data: 2020-08-16-13:25
     * @method: match
     * @params: [metadataReader, metadataReaderFactory]
     * @return: boolean
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("-----> " + className);
        if (className.contains("er")){
            return true;
        }

        return false;
    }
}
