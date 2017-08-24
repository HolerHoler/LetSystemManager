<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../include/meta.jsp"%>
<title>修改密码</title>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
</head>
<body>
	<article class="page-container"> <s:form namespace="/action"
		action="changePasswordAdmin" class="form form-horizontal"
		method="post">

		<s:hidden name="username" value="%{username}" />

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="username" label="用户名" class="input-text"
					disabled="true" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>旧密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:password name="old_password" label="旧密码" class="input-text" />
			</div>
			<div class="formControls col-xs-8">
				<s:fielderror fieldName="old_password"></s:fielderror>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>新密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:password name="password" label="新密码" class="input-text" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>确认新密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:password name="confirm_password" label="再一次输入新密码"
					class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="提交">
			</div>
		</div>

	</s:form> </article>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
	$.validator.setDefaults({
		submitHandler : function() {
			$("#changePasswordAdmin").ajaxSubmit(function(result) {
				console.log(result.message);
				if (result.message == "success") {
					parent.location.href = "/LetSystemManager/login.jsp";
				} else {
					alert("修改密码失败");
				}
				//parent.location.replace(parent.location.href);
				//	var index = parent.layer.getFrameIndex(window.name);
				//	parent.$('.btn-refresh').click();
				//	parent.layer.close(index);

			});
		}
	});
	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		$("#changePasswordAdmin").validate({
			rules : {
				"username" : {
					required : true,
				},
				"old_password" : {
					required : true,
				},
				"password" : {
					required : true,
				},
				"confirm_password" : {
					required : true,
					equalTo : "#changePasswordAdmin_password"
				},
			}
		});
	});
</script>
</html>