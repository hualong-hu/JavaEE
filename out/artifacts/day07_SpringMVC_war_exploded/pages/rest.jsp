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
<%--
    发起图书的增删改查请求。使用REST风格的URL地址
    请求URL：      请求方式        表示含义
    /book/1         GET         查询一号图书
    /book/1         DELETE      删除一号图书
    /book/1         PUT         更新一号图书
    /book/1         POST        添加一号图书

    从页面发起put、delete形式的请求，Spring提供了对Rest风格的支持
    1、SpringMVC中有一个Filter过滤器，它可以把普通的请求转换为规定形式的请求，先在web.xml中配置这个Filter
    2、创建一个post类型的表单，表单项中携带一个_method的参数，这个_method的值就是delete、put

--%>

<form action="book/1" method="get">
    <input type="submit" value="查询一号图书"/>
</form><br/>
<form action="book/1" method="post">
    <input type="submit" value="添加一号图书"/>
</form><br/>
<form action="book/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除一号图书"/>
</form><br/>
<form action="book/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="更新一号图书"/>
</form><br/>

</body>
</html>
