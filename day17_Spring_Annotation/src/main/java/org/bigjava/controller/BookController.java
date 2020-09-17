package org.bigjava.controller;

import org.bigjava.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ProjectName: JavaEE
 * @ClassName: BookController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 12:58
 * @Version v1.0
 */
@Controller
public class BookController {

    @Autowired
    BookService bookService;
}
