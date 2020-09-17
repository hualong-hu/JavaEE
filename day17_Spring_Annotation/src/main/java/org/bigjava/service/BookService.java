package org.bigjava.service;

import org.bigjava.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @ProjectName: JavaEE
 * @ClassName: BookService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 12:59
 * @Version v1.0
 */
@Service
public class BookService {

//    @Autowired(required = false)
//    @Qualifier("bookMapper")
//    @Resource(name = "bookMapper")
    @Inject
    BookMapper bookMapper;

    public void print(){
        System.out.println("bookMapper注入成功-->"+bookMapper);
    }
}
