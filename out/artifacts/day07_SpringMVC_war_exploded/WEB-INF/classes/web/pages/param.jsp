<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-17
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="param1">
    用户名：<input type="text" name="username">
    <input type="submit" value="提交">
</form>

<form action="addBook" method="post">
    作者：<input type="text" name="authorName"><br/>
    书名：<input type="text" name="bookName"><br/>
    价格：<input type="text" name="price"><br/>
    作者的个人信息<br>
    电话号码：<input type="text" name="author.phone"><br/>
    邮箱：<input type="text" name="author.email"><br/>
    年龄：<input type="text" name="author.age"><br/>
    <input type="submit">
</form>

<form action="param2" method="get">
    <input type="submit" value="测试SpringMVC中的原生API">
</form>
</body>
</html>
