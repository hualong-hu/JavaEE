<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-12-04
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>表单数据获取</h1>
    <form action="testForm1" method="get">
        username：<input type="text" value="洛笙" name="username"><br/>
        password：<input type="password" value="123456" name="password"><br/>
        address：<input type="text" value="南昌" name="address"><br/>
        <input type="submit" value="提交"/>
    </form>
<hr color="red"/>
    <h1>表单数据封装(模型驱动封装)</h1>
    <form action="testForm2" method="get">
        username：<input type="text" value="洛笙" name="username"><br/>
        password：<input type="password" value="123456" name="password"><br/>
        address：<input type="text" value="南昌" name="address"><br/>
        <input type="submit" value="提交"/>
    </form>
<hr color="red"/>
    <h1>表单数据封装(表达式封装)</h1>
    <form action="testForm3" method="get">
        username：<input type="text" value="洛笙" name="user.username"><br/>
        password：<input type="password" value="123456" name="user.password"><br/>
        address：<input type="text" value="南昌" name="user.address"><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
