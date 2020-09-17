<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>洛笙书城会员注册页面</title>
	<%--  静态包含base标签，css样式，jQuery文件	--%>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="" >
				<span class="wel_word"></span>
				<div>
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="../order/order.jsp">我的订单</a>
					<a href="../../index.jsp">注销</a>&nbsp;&nbsp;
					<a href="../../index.jsp">返回</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.jsp">转到主页</a></h1>
	
		</div>

		<%--  静态包含页脚内容	--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>