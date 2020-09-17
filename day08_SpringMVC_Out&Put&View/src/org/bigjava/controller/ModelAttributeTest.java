package org.bigjava.controller;

import org.bigjava.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: JavaEE
 * @ClassName: ModelAttributeTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-20 17:45
 * @Version v1.0
 */
@Controller
public class ModelAttributeTest {

    @RequestMapping("/pages/updateBook")
    public String updateBook(@ModelAttribute("book") Book book){
        System.out.println("页面提交过来的图书信息是："+book);
        return "success";
    }

    /**
     * 1）、SpringMVC要封装请求参数的Book对象，不应该是自己new出来的
     *      而应该是【从数据库中】拿到的准备好的对象
     * 2）、再来使用这个对象封装请求参数
     *      @ModelAttribute
     *          参数位置：取出保存的数据
     *          方法位置：这个方法就会提取于目标方法先执行
     *                  1、我们可以在这个提前查出数据库中图书的信息
     *                  2、将这个图书信息保存起来（方便下一个方法使用）
     * 3）、参数中的Model：BindingAwareModelMap
     * @data: 2020-07-20-17:55
     * @method: testModelAttribute
     * @params: []
     * @return: void
     */
    @ModelAttribute
    public void testModelAttribute(Model model){
        Book book = new Book("西游记", "吴承恩", 20.2, 30, 40);
        System.out.println("数据库中查到的图书信息是："+book);
        model.addAttribute("book", book);
        System.out.println("ModelAttribute方法....查询了图书并保存起来了！");
    }

}
