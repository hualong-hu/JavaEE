<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-24
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工修改</title>
    <base href="http://localhost:8080/day10/">
</head>
<body>
<h1>员工修改页面</h1>
<form:form action="updates/${employee.id}" modelAttribute="employee"  method="post">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="id" value="${employee.id}">
    email:<form:input path="email"/><br/>
    <br/>
    gender:&nbsp;&nbsp;
    男：<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;
    女：<form:radiobutton path="gender" value="0"/><br/>
    <br/>
    department：<form:select path="department.id" items="${departments}" itemLabel="departmentName"
                            itemValue="id"/><br/>
    <br/>
    <input type="submit" value="修改">
</form:form>


</body>
</html>
