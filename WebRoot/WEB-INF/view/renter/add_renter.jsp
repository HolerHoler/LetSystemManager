<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../include/meta.jsp"%>
<%@ page isELIgnored="false"%>
<title>添加经纪人</title>
</head>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
<body>
	<article class="page-container"> <s:form namespace="/action"
		action="addRenter" class="form form-horizontal" method="post">

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>证件类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width:150px;"> <s:select
						label="证件类型" headerKey="0" headerValue="请选择证件类型" class="select"
						size="1"
						list="#{'身份证':'1-身份证', '护照':'2-护照', '军官证':'3-军官证', '户口本':'4-户口本'}"
						name="renter.credentials_type" listKey="key" listValue="value" />
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>证件号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="renter.credentials_id" label="证件号"
					class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="renter.personName" label="姓名" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="renter.telephone" label="联系电话" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<!-- 		<input type="button" id="addRenter_0" value="增加"
					class="btn btn-primary radius" /> -->
				<input class="btn btn-primary radius" type="submit" value="提交">
			</div>
		</div>


		<%-- 	<s:select label="证件类型" headerKey="0" headerValue="请选择证件类型"
			list="#{'身份证':'1-身份证', '护照':'2-护照', '军官证':'3-军官证', '户口本':'4-户口本'}"
			name="renter.credentials_type" listKey="key" listValue="value" />
		<s:textfield name="renter.credentials_id" label="证件号" />
		<s:textfield name="renter.personName" label="姓名" />
		<s:textfield name="renter.telephone" label="联系电话" />
		<s:submit value="添加" /> --%>
	</s:form> </article>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/messages_zh.js"></script>
<%-- <script type="text/javascript">
	$(document).ready(function() {
		$("#addRenter_0").click(function() {
			//	$("#updatedLet").ajaxSubmit();

			$("#addRenter").ajaxSubmit(function(result) {
				console.log(result.message);
				parent.location.replace(parent.location.href);
				var index = parent.layer.getFrameIndex(window.name);
				//	parent.$('.btn-refresh').click();
				parent.layer.close(index);
			});
			return false; //阻止表单默认提交
		});
	});
</script> --%>
<script type="text/javascript">
	$.validator.setDefaults({
		submitHandler : function() {
			$("#addRenter").ajaxSubmit(function(result) {
				console.log(result.message);
				parent.location.replace(parent.location.href);
				var index = parent.layer.getFrameIndex(window.name);
				//	parent.$('.btn-refresh').click();
				parent.layer.close(index);
			});
		}
	});
	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		$("#addRenter").validate({
			rules : {
				"renter.personName" : {
					required : true,
				},
				"renter.credentials_id" : {
					required : true,
				},
				"renter.telephone" : {
					required : true,
				},
			}
		});
	});
</script>
</html>