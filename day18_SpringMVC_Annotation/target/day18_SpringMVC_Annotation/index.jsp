<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<h2>Hello World!</h2>
<h1><a href="${path}/test1">测试1</a></h1>
</body>
</html>
