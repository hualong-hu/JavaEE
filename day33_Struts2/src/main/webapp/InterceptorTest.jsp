<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-12-06
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login" method="post">
        <div>${requestScope.msg}</div>
        用户名：<input type="text" name="username" value="洛笙"><br/>
        密码：<input type="password" name="password" value="123456"><br/>
        <input type="submit" value="登录">
    </form>
<h1><a href="test">测试拦截器拦截未登录状态！！</a> </h1>
</body>
</html>
