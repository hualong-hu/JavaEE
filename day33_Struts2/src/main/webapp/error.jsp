<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-12-06
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
异常信息会存放到值栈中
为了在异常处理页面中显示异常信息，我们可以使用Struts2的标签来输出异常信息。

    <s:property value="exception"/>：输出异常对象本身。

    <s:property value="exceptionStack"/>：输出异常堆栈信息

对于第一种直接输出异常对象本身的方式，完全可以使用表达式。


--%>
<h1>不好意思，您的系统出错了！！！！</h1>
<s:debug>

</s:debug>
<h1><c:property value="exception"/> </h1>
</body>
</html>
