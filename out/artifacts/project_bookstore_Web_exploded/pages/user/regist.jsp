<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>洛笙书城会员注册页面</title>
<%--  静态包含base标签，css样式，jQuery文件	--%>
<%@ include file="/pages/common/head.jsp"%>
<script type="text/javascript">

	$(function () {

		$("#username").blur(function () {
			//获取用户名
			var username = this.value;

			$.getJSON("http://localhost:8080/project_bookstore_war_exploded/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
				if (data.existsUsername){
					$(".errorMsg").text("用户名已存在！");
				}else {
					$(".errorMsg").text("用户名可用！");
				}

			})
		})



		//给验证码图片绑定单击事件
		$("#code_img").click(function () {
			//在事件响应的function函数中有一个this对象，这个this对象，是当前正在响应事件的dom对象
			//src属性表示验证码img标签的图片路径，它可读可写！
			this.src="${basePath}kaptcha.jpg?d="+new Date();
		})

		// 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
		$("#sub_btn").click(function () {
			var username = $("#username").val();
			var usernamePatt = /^\w{5,12}$/;
			if ( !usernamePatt.test(username)){
				$(".errorMsg").text("用户名不合法");

				return false;
			}

			// 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
			var password = $("#password").val();
			var passwordPatt = /^\w{5,12}$/;
			if (!passwordPatt.test(password)){
				$(".errorMsg").text("密码不合法");

				return false;
			}

			// 验证确认密码：和密码相同
			var newPassword = $("#repwd").val();
			if (newPassword != password){
				$(".errorMsg").text("密码不一致！");
				return false;
			}

			// 邮箱验证：xxxxx@xxx.com
			var email = $("#email").val();
			var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			if (!emailPatt.test(email)){
				$(".errorMsg").text("邮箱格式不合法！");
				return false;
			}

			// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
			var code = $("#code").val();
			var codeTrim = $.trim(code);
			if (codeTrim == null || codeTrim == "${sessionScope.KAPTCHA_SESSION_KEY}"){
				$(".errorMsg").text("验证码错误");
				return false;
			}


			$(".errorMsg").text("");
		});
	})
</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="../../static/img/logo.jpg" height="80">
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册洛笙书城会员</h1>
								<span class="errorMsg">
									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
											value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
											value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 100px;" id="code" name="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px ; width: 100px;height: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		<%--  静态包含页脚内容	--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>