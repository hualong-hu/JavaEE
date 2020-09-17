<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-28
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<head>
    <title>Title</title>
</head>
<body>
    <h1><a href="${path}/test1">拦截器test1</a> </h1>
    <h1><a href="${path}/test2">拦截器test2</a> </h1>
</body>
</html>
