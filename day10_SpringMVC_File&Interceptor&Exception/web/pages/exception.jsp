<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-28
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<body>
<h1><a href="${path}/exception1?i=0">测试@ExceptionHandler</a></h1>
<h1><a href="${path}/exception2?username=admin">测试@ResponseStatus</a></h1>
<h1><a href="${path}/exception3">测试SimpleMappingExceptionResolver</a></h1>


</body>
</html>
