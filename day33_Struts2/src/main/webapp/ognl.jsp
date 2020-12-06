<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-12-05
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        使用OGNL+struts2标签实现计算字符串长度
        value值：ognl表达式
    --%>
    <s:property value="'haha'.length()"/>
<%--  使用struts2标签查看值栈结构  --%>
    <s:debug>

    </s:debug>
    <h1>获取值栈中的数据</h1>
    <h1>name:<s:property value="name"/></h1>
    <hr color="red">
    <h1>获取值栈中的对象</h1>
    <h1>username:<s:property value="user.username"/></h1>
    <h1>password:<s:property value="user.password"/></h1>
    <h1>address:<s:property value="user.address"/></h1>
    <hr color="red">
    <h1>获取值栈中的list集合----第一种方法</h1>
    username:<s:property value="list[0].username"/>
    password:<s:property value="list[0].password"/>
    address:<s:property value="list[0].address"/>
    <br/>
    username:<s:property value="list[1].username"/>
    password:<s:property value="list[1].password"/>
    address:<s:property value="list[1].address"/>
    <h1>获取值栈中的list集合----第二种方法</h1>
    <%--
        使用struts2标签<s:iterator value="">，遍历值栈的list集合
        遍历list得到list里面每个user对象
      --%>
    <s:iterator value="list">
        <s:property value="username"/>
        <s:property value="password"/>
        <s:property value="address"/>
        <br/>
    </s:iterator>
    <h1>获取值栈中的list集合----第三种方法</h1>
    <%--
        遍历值栈list集合，得到每个user对象
        机制：把每次遍历出的user对象放到context里面
        获取context里面数据特点，写ognl表达式
        使用特殊符号 #
    --%>
    <s:iterator value="list" var="user">
        <s:property value="#user.username"/>
        <s:property value="#user.password"/>
        <s:property value="#user.address"/>
        <br/>
    </s:iterator>
    <hr color="red">
    <h1>使用jstl获取值栈中list集合</h1>
    <c:forEach items="${list}" var="user">
        ${user.username}
        ${user.password}
        ${user.address}
        <br/>
    </c:forEach>

</body>
</html>
