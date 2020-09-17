package org.bigjava.controller;
import	java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: JavaEE
 * @ClassName: OutPutController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-20 14:55
 * @Version v1.0
 * SpringMVC除在方法上传入原生的request和session外还能有其他方法将数据带给页面
 *  1）、可以在方法处传入Map、Model或者ModelMap。
 *      给这些参数里面保存的所有数据都会放在request域中，可以在页面获取
 *      三者的关系：
 *          Map、Model、ModelMap：最终都是BindingAwareModelMap在工作；
 *          相当于给BindingAwareModelMap中保存的东西都会放在request域中
 *
 *          Map(interface(JDK))                 Model(interface(Spring))
 *              ||                                //
 *              ||                               //
 *              \/                              //
 *          ModelMap(class)                    //
 *                       \\                   //
 *                        \\                 //
 *                          ExtendedModelMap
 *                                 ||
 *                       BindingAwareModelMap
 *
 *  2）、方法的返回值可以变为ModelAndView类型：
 *      既包含视图信息（页面地址）也包含模型数据（给页面带的数据）；而且数据是放在请求域中！
 */
@Controller

public class OutPutController {

    @RequestMapping("/pages/map")
    public String testMap(Map<String, Object> map){
        map.put("msg", "map测试！！！！");
        return "success";
    }

    @RequestMapping("/pages/model")
    public String testModel(Model model){
        model.addAttribute("msg", "Model测试！！！！");
        return "success";
    }

    @RequestMapping("pages/modelmap")
    public String testModelMap(ModelMap map){
        map.addAttribute("msg", "ModelMap测试！！！！");
        return "success";
    }
    @RequestMapping("pages/modelandview")
    public ModelAndView testModelAndView(){
        //之前的返回值我们就叫视图名，视图名会被视图解析器最终拼串得到页面的真实地址
        ModelAndView view = new ModelAndView("success");
        view.addObject("msg", "ModelAndView测试！！！！");
        return view;

    }
}
