<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@ include file="WEB-INF/view/include/meta.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<title>登陆</title>
</head>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
<body>

<!-- 	<s:form action="tryLogin" namespace="/action"> -->
<!-- 		<s:textfield name="username" label="用户名"></s:textfield> -->
<!-- 		<s:password name="password" label="密码"></s:password> -->
<!-- 		<s:submit value="登陆" /> -->
<!-- 	</s:form> -->


		<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<s:form action="tryLogin" namespace="/action"
				class="form form-horizontal">

				<div class="row cl">
					<label class="form-label col-xs-3"> <i class="Hui-iconfont">&#xe60d;</i>
					</label>
					<div class="formControls col-xs-8">

						<s:textfield id="username" name="username" label="用户名"
							placeholder="账户" class="input-text size-L"></s:textfield>
					</div>
					<div class="formControls col-xs-8">
						<s:fielderror fieldName="username"></s:fielderror>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"> <i class="Hui-iconfont">&#xe60e;</i>
					</label>
					<div class="formControls col-xs-8">
						<s:password id="password" name="password" label="密码"
							placeholder="密码" class="input-text size-L"></s:password>
					</div>
					<div class="formControls col-xs-8">
						<s:fielderror fieldName="password"></s:fielderror>
					</div>
				</div>


				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" type="text" placeholder="验证码"
							onblur="if(this.value==''){this.value='验证码:'}"
							onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:"
							style="width:150px;"> <img src=""> <a id="kanbuq"
							href="javascript:;">看不清，换一张</a>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online"> <input type="checkbox" name="online"
							id="online" value=""> 使我保持登录状态
						</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="" type="submit" class="btn btn-success radius size-L"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input
							name="" type="reset" class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</s:form>
		</div>
	</div>






	<%-- 	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal"
				action="${pageContext.request.contextPath}/action/tryLogin.action"
				method="post">
				<div class="row cl">
					<label class="form-label col-xs-3"> <i class="Hui-iconfont">&#xe60d;</i>
					</label>
					<div class="formControls col-xs-8">
						<input id="username" name="username" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"> <i class="Hui-iconfont">&#xe60e;</i>
					</label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" type="text" placeholder="验证码"
							onblur="if(this.value==''){this.value='验证码:'}"
							onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:"
							style="width:150px;"> <img src=""> <a id="kanbuq"
							href="javascript:;">看不清，换一张</a>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online"> <input type="checkbox" name="online"
							id="online" value=""> 使我保持登录状态
						</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="" type="submit" class="btn btn-success radius size-L"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input
							name="" type="reset" class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
 --%>




</body>

<%-- <script type="text/javascript">
	$(document).ready(function() {
		$("#button_login").click(function() {
			login(); //点击ID为"button_login"的按钮后触发函数 login(); 
		});
		var path = '${pageContext.request.contextPath}';
		function login() { //函数 login(); 
			var username = $("#username").val();//取框中的用户名 
			var password = $("#password").val();//取框中的密码 
			$.ajax({ //调用Ajax方法 
				type : "post", //以post方式与后台沟通 
				url : path + "/action/ajaxLogin.action",
				dataType : 'json',
				data : {
					username : username,
					password : password
				},
				success : function(result) {
					console.log(result);
					var value = result.message;
					if (value == "success") {
						console.log(value);
					} else {
						alert(value);
						$("#c").html(value);
					}
					$("#c").html(value);
				},
				error : function(result) {
					console.log(result);
				}
			});
		}
	});
</script> --%>
</html>