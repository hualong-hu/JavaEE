<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-23
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/day10/">
</head>
<body>
<%--
表单标签：
    通过SpringMVC的表单标签可以实现将模型数据中的属性和HTML表单元素相绑定，
    以实现表单数据更便捷编辑和表单值的回显
    1）、SpringMVC认为：表单数据中的每一项最终都是要回显的；
        path指定的是一个属性：这个属性是从隐含模型中拿出来的（请求域中取出的某个对象中的属性）
        path指定的每一个属性：请求域中必须有一个对象拥有这个属性；
            这个对象就是请求域中的command
        modelAttribute=" " ：
            1）、以前吗表单标签会从请求域中获取一个command对象，把这个对象的每一个属性对应的显示出来
            2）、这个属性可以告诉SpringMVC不要去取command的值了，我放了一个modelAttribute指定的值，
                取对象用的key就用我modelAttribute的值
--%>

<form:form action="saveEmployee" modelAttribute="employee" method="post">
    <%--
        path：就是原来HTML中input标签中的name属性，需要些
        作用：1）、当做原生的name属性
             2）、自动回显隐含函数中某个对象对应的这个属性的值

    --%>
    LastName:<form:input path="lastName"/><br/>
    <br/>
    Email:<form:input path="email"/><br/>
    <br/>
    Gender:
        Male<form:radiobutton path="gender" value="1"/>
        Female<form:radiobutton path="gender" value="0"/><br/>
    <br/>
    <%--
        items=" "  指定要遍历的集合；自动遍历，遍历出的每一个元素是一个department对象
        itemLabel="属性名"  指定遍历出的这个对象的那个属性是作为option标签体的值
        itemValue="属性名"  指定刚才遍历出来的这个对象的哪个属性作为要提交的Value值

    --%>
    <br/>
    生日：<form:input path="birth"/><br/>
    Department:&nbsp;
    <form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id" /><br/>
    <br/>
    <input type="submit" value="保存">
</form:form>
<%--    <form action="saveEmployee">--%>
<%--        LastName:<input type="text" name="lastName"><br/>--%>
<%--        <br/>--%>
<%--        Email:<input type="text" name="email"><br/>--%>
<%--        <br/>--%>
<%--        Gender:--%>
<%--            Male<input type="radio" name="gender" value="1">&nbsp;--%>
<%--            Female<input type="radio" name="gender" value="0"><br/>--%>
<%--        <br/>--%>
<%--        Department:&nbsp;<select name="department.id">--%>
<%--                        <c:forEach items="${requestScope.departments}" var="entry">--%>
<%--                            <option value="${entry.id}">${entry.departmentName}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--        <br/>--%>
<%--        <br/>--%>
<%--        <input type="submit">--%>
<%--    </form>--%>

</body>
</html>
