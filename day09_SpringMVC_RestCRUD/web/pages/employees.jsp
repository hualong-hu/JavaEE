<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-23
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../scripts/jquery-1.9.1.min.js"></script>
<html>
<head>
    <base href="http://localhost:8080/day09/">
    <title>员工列表</title>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                //1.改变表单的action的指向
                $("#deleteForm").attr("action",this.href);
                //2.提交表单
                $("#deleteForm").submit();
            });
        })
    </script>
</head>
<body>
<h1>员工列表</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>birth</th>
        <th>departmentName</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${requestScope.allEmployees}" var="entry">
        <tr>
            <td>${entry.id}</td>
            <td id="employeeName">${entry.lastName}</td>
            <td>${entry.email}</td>
            <td>${entry.gender == 0?"女":"男"}</td>
            <td>${entry.birth}</td>
            <td>${entry.department.departmentName}</td>
            <td>
                <a href="update/${entry.id}">EDIT</a>
            </td>
            <td>
                <a href="deleteEmployee/${entry.id}" class="delete">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2><a href="addEmployee">添加员工</a> </h2>
<form action="deleteEmployee/${entry.id}" method="post" id="deleteForm">
    <input type="hidden" name="_method" value="DELETE">
</form>
<h2><a href="pages/ajax.jsp">AJAX测试</a></h2>
<h2><a href="pages/testRequestBody.jsp">测试RequestBody</a></h2>
</body>
</html>
