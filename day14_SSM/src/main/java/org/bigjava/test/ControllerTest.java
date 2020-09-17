//package org.bigjava.test;
//
//import com.github.pagehelper.PageInfo;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
///**
// * @ProjectName: JavaEE
// * @ClassName: ControllerTest
// * @Description: TODO
// * @Author: 洛笙
// * @Date: 2020-08-09 18:08
// * @Version v1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:C:\\Users\\洛笙\\IdeaProjects\\JavaEE\\day14_SSM\\src\\main\\webapp\\WEB-INF\\dispatcherServlet-servlet.xml"})
//public class ControllerTest {
//    //传入springmvc的ioc
//    @Autowired
//    WebApplicationContext context;
//    //虚拟mvc请求，获取到处理结果
//    @Autowired
//    MockMvc mockMvc;
//
//    @Before
//    public void test(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//    @Test
//    public void test1() throws Exception {
//        //模拟请求拿到返回值
//        MvcResult resultActions = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get("/employees").param("pageNum", "1"));
//
//        //请求成功后，请求域中有pageInfo
//        MockHttpServletRequest request = resultActions.getRequest();
//        PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
//        System.out.println("当前页码："+pageInfo.getPageNum());
//        System.out.println("总页码："+pageInfo.getPages());
//        System.out.println("总记录数："+pageInfo.getTotal());
//        System.out.println("在页面需要连续显示的页码：");
//        int[] nums = pageInfo.getNavigatepageNums();
//        for (int num : nums) {
//            System.out.print(" " + num);
//        }
//
//        //获取员工数据
//        List<Employee> list = pageInfo.getList();
//        for (Employee employee : list) {
//            System.out.println("ID："+employee.getEmployeeId()+"==>name："+employee.getEmployeeName());
//        }
//
//    }
//}
