<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-27
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../scripts/jquery-1.9.1.min.js"></script>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/testRequestBody" method="post">
        <input type="text" name="username" value="tomcat"/>
        <input type="password" name="password" value="123456"/>
        <input type="submit">
    </form>
    <br/>
    <h2>ajax发送json数据</h2>
    <form action="${pageContext.request.contextPath}/testRequestBody1" method="post">
        <input type="text" name="username" value="tomcat"/>
        <input type="password" name="password" value="123456"/>
        <input type="submit" value="ajax发送json数据">
    </form><br>
    <a href="${pageContext.request.contextPath}/testRequestBody1">ajax发送json数据</a>
    <script type="text/javascript">
        $("a:first").click(function () {
            var emp = {lastName:"张三",email:"666@qq.com",gender:0};
            var stringify = JSON.stringify(emp);
            $.ajax({
                url:"${pageContext.request.contextPath}/testRequestBody1",
                type:"post",
                data:stringify,
                success:function (data) {
                    alert(data);
                }
            })

        })
    </script>

</body>
</html>
