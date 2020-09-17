<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-17
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="hello">hello</a>
  <br/>
  <h1><a href="test1">test01--写在方法上的requestMapping</a></h1><br/>
  <h1><a href="haha/test1">test01--写在类上的requestMapping</a></h1><br/>
  <h1>test02--requestMapping的其他属性</h1><br/>
  <a href="haha/test2">method属性测试</a><br>
  <form action="haha/test2" method="post">
    <input type="submit" value="method属性测试">
  </form>

  <a href="haha/test3">params属性测试没带任何参数</a><br>
  <form action="haha/test3" method="get">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="params属性测试">
  </form><br/>

  <a href="haha/test4">headers属性测试</a><br>
  <hr color="red"/>
  <h1>RequestMapping-Ant风格的URL</h1>
  <a href="antTest1">精确请求地址-AntTest1</a><br/>
  <a href="antTest2">模糊请求地址-AntTest2</a><br/>
  <a href="user/admin">测试PathVariable</a><br/>
  <hr color="red"/>
  <h1><a href="pages/rest.jsp">发起图书的增删改查请求。使用REST风格的URL地址</a></h1><br/>
  <hr color="red"/>

  <h1><a href="pages/param.jsp">参数</a></h1><br/>
  <h1><a href="pages/param.jsp">获取请求参数</a></h1><br/>
  </body>
</html>
