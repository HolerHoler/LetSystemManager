<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<%@ include file="../include/meta.jsp"%>
<title>房管信息</title>
</head>
<body>
	<article class="page-container"> <s:form namespace="/action"
		action="updatedBrokerHouse" class="form form-horizontal" method="post">
		<s:hidden name="brokerHouse.id" value="%{brokerHouse.id}" />
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>经纪人id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="brokerHouse.broker.id" label="经纪人id"
					class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>经纪人姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="brokerHouse.broker.personName" label="经纪人姓名"
					disabled="true" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="brokerHouse.house.id" label="房子id"
					class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子名字：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="brokerHouse.house.houseName" label="房子名字"
					disabled="true" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<!-- <input type="button" id="updatedBrokerHouse_0" value="更新"
					class="btn btn-primary radius" /> -->
				<input class="btn btn-primary radius" type="submit" value="提交">
			</div>
		</div>
	</s:form></article>
	<%-- <s:form namespace="/action" action="updatedBrokerHouse">
		<s:hidden name="brokerHouse.id" value="%{brokerHouse.id}" />
		<s:textfield name="brokerHouse.broker.id" label="经纪人id" />
		<s:textfield name="brokerHouse.broker.personName" label="经纪人姓名"
			disabled="true" />
		<s:textfield name="brokerHouse.house.id" label="房子id" />
		<s:textfield name="brokerHouse.house.houseName" label="房子名字"
			disabled="true" />
		<s:submit value="更新" />
	</s:form> --%>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#updatedBrokerHouse_brokerHouse_broker_id").blur(
								function() {
									ajaxBrokerHouse();
								});
						$("#updatedBrokerHouse_brokerHouse_house_id").blur(
								function() {
									ajaxBrokerHouse();
								});
						var path = '${pageContext.request.contextPath}';
						function ajaxBrokerHouse() {
							var broker_id = $(
									"#updatedBrokerHouse_brokerHouse_broker_id")
									.val();
							var house_id = $(
									"#updatedBrokerHouse_brokerHouse_house_id")
									.val();
							if (house_id == null && broker_id == null) {
								return;
							}
							alert(house_id);
							$
									.ajax({ //调用Ajax方法 
										type : "post", //以post方式与后台沟通 
										url : path
												+ "/action/ajaxBrokerHouse.action",
										dataType : 'json',
										data : {
											"brokerHouse.broker.id" : broker_id,
											"brokerHouse.house.id" : house_id
										},
										success : function(result) {
											console.log(result);
											var value = result.message;
											if (value == "success") {
												console.log(value);
											} else {
												console.log(value);
											}
											if (result.broker != null) {
												$(
														"#updatedBrokerHouse_brokerHouse_broker_personName")
														.val(
																result.broker.personName);
											} else {
												$(
														"#updatedBrokerHouse_brokerHouse_broker_personName")
														.val("");
											}
											if (result.house != null) {
												$(
														"#updatedBrokerHouse_brokerHouse_house_houseName")
														.val(
																result.house.houseName);
											} else {
												$(
														"#updatedBrokerHouse_brokerHouse_house_houseName")
														.val("");
											}
										}
									});
						}
					});
	/* 	$(document).ready(function() {
	 $("#updatedBrokerHouse_0").click(function() {
	 //	$("#updatedLet").ajaxSubmit();

	 $("#updatedBrokerHouse").ajaxSubmit(function(result) {
	 console.log(result.message);
	 parent.location.replace(parent.location.href);
	 var index = parent.layer.getFrameIndex(window.name);
	 //	parent.$('.btn-refresh').click();
	 parent.layer.close(index);
	 });
	 return false; //阻止表单默认提交
	 });
	 }); */
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
	$.validator.setDefaults({
		submitHandler : function() {
			$("#updatedBrokerHouse").ajaxSubmit(function(result) {
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
		$("#updatedBrokerHouse").validate({
			rules : {
				"brokerHouse.house.id" : {
					required : true,
				},
				"brokerHouse.broker.id" : {
					required : true,

				}
			},
		});
	});
</script>
</html>