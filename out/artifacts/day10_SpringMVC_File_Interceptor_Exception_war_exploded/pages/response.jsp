<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-27
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        pageContext.setAttribute("path", request.getContextPath());
    %>
    <title>Title</title>
</head>
<body>
    <h2><a href="${path}/requestBody">RequestBody测试！！</a></h2>
<%--    <form action="${path}/test1" method="post">--%>
<%--        <input type="text" value="6666"><br/>--%>
<%--        <input type="submit">--%>
<%--    </form>--%>
    <h2><a href="${path}/responseEntity">responseEntity测试！！</a></h2>
</body>
</html>
