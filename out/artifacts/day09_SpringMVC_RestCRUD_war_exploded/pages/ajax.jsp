<%@ page import="java.util.Date" %>
<%@ page import="javax.validation.constraints.Past" %><%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-27
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<%=new Date()%>
<a href="${pageContext.request.contextPath}/getAll">ajax获取所有员工</a>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function () {
        //1.发送ajax获取所有员工
        $.ajax({
            url:"${pageContext.request.contextPath}/getAll",
            type:"GET",
            success:function (date) {
                $.each(date,function(){
                   var empInfo = this.lastName+"-->"+this.birth+"-->"+this.gender;

                   $("div").append(empInfo+"<br/>");
                });
            }
        })
        return false;


    })
</script>

</body>
</html>
