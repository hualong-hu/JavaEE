<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-07-27
  Time: 16:30
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
<h2><a href="${path}/download">download测试！！</a></h2>
<br/>
<br/>
<h2>文件上传测试！！</h2><br/>
<%--
    1、文件上传
        1.文件上传表单准备：enctype="multipart/form-data"
        2.导入 commons-io-2.0.jar
              commons-fileupload-1.2.1.jar
        3.在SpringMVC配置文件中，编写一个配置文件上传解析器（CommonsMultipartResolver）
        4.文件上传请求处理

--%>
<h3>单文件上传</h3>
<form action="${path}/upload" method="post" enctype="multipart/form-data">
    用户头像：<input type="file" name="headerimg"><br/>
    上传路径：<input type="text" name="path"><br/>
    用户名：<input type="text" name="username"/><br/>
    <input type="submit"/>
</form>
<h3>多文件上传</h3>
<form action="${path}/uploadSome" method="post" enctype="multipart/form-data">
    用户头像：<input type="file" name="headerimg"><br/>
    用户头像：<input type="file" name="headerimg"><br/>
    用户头像：<input type="file" name="headerimg"><br/>
    用户头像：<input type="file" name="headerimg"><br/>
    用户名：<input type="text" name="username"/><br/>
    <input type="submit"/>
</form>
</body>
</html>
