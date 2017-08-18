<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<%@ include file="../include/meta.jsp"%>
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>添加出租信息</title>
</head>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
<body>
	<s:action name="bhLet" namespace="/action" executeResult="false"
		var="letAction" ignoreContextParams="false" />
	<%-- 	<s:property value="#letAction.brokerHouseList" /> --%>
	<article class="page-container"> <s:form namespace="/action"
		action="addLet" method="post" class="form form-horizontal">

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>租约名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="letInfo.letName" label="租约名" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width:150px;"> <s:select
						class="select" name="letInfo.houseInfo.id"
						list="#letAction.brokerHouseList" listKey="house.id"
						listValue="house.id" label="房子id" headerKey="0"
						headerValue="--请选择--" value="letInfo.houseInfo.id" />
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="letInfo.houseInfo.houseName" label="房子名字"
					disabled="true" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>租客id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="letInfo.renter.id" label="租客id"
					class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>租客名字：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="letInfo.renter.personName" label="租客名字"
					disabled="true" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>经纪人id：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width:150px;"> <s:select
						class="select" name="letInfo.broker.id"
						list="#letAction.brokerHouseList" listKey="broker.id"
						listValue="broker.id" label="经纪人id" headerKey="0"
						headerValue="--请选择--" />
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>经纪人名字：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="letInfo.broker.personName" label="经纪人名字"
					disabled="true" class="input-text" />
			</div>
		</div>


		<%-- 		<sx:datetimepicker name="letInfo.beginTime" displayFormat="yyyy-MM-dd"
			label="起始日期"></sx:datetimepicker> --%>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>起始日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="formControls col-xs-8 col-sm-9">
					<input type="date" id="logmin" class="input-text Wdate"
						style="width:160px;" name="letInfo.beginTime">
				</div>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>天数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="letInfo.dayNum" label="天数" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>结束日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="date" id="logmin" class="input-text Wdate"
					style="width:160px;" name="letInfo.endTime">
			</div>
		</div>

		<%-- 
		<sx:datetimepicker name="letInfo.endTime" displayFormat="yyyy-MM-dd"
			label="结束日期"></sx:datetimepicker> --%>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<%-- 		<s:submit value="增加" class="btn btn-primary radius" /> --%>

				<input class="btn btn-primary radius" type="submit" value="提交">
				<!-- 			<input type="button" id="addLet_0" value="增加"
					class="btn btn-primary radius" /> -->
			</div>
		</div>
	</s:form> </article>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var path = '${pageContext.request.contextPath}';
						$("#addLet_letInfo_houseInfo_id").change(function() {
							ajaxLet_House();
						});

						function ajaxLet_House() {
							var house_id = $("#addLet_letInfo_houseInfo_id")
									.val();
							$
									.ajax({ //调用Ajax方法 
										type : "post", //以post方式与后台沟通 
										url : path
												+ "/action/ajaxHouseLet.action",
										dataType : 'json',
										data : {
											"letInfo.houseInfo.id" : house_id
										},
										success : function(result) {
											$("#addLet_letInfo_broker_id")
													.empty();
											$("#addLet_letInfo_broker_id")
													.append(
															"<option value='"+0+"'>"
																	+ "请选择"
																	+ "</option>");
											for (var i = 0; i < result.brokerHouseList.length; i++) {
												var value = result.brokerHouseList[i].broker.id;
												$("#addLet_letInfo_broker_id")
														.append(
																"<option value='"+value+"'>"
																		+ value
																		+ "</option>");
											}

											console.log(result);
											var value = result.message;
											if (value == "success") {
												console.log(value);
											} else {
												console.log(value);
											}
											$(
													"#addLet_letInfo_houseInfo_houseName")
													.val(result.house.houseName);
										}
									});
						}

						$("#addLet_letInfo_renter_id").blur(function() {
							ajaxLet_Renter();
						});

						function ajaxLet_Renter() {
							var renter_id = $("#addLet_letInfo_renter_id")
									.val();
							$.ajax({ //调用Ajax方法 
								type : "post", //以post方式与后台沟通 
								url : path + "/action/ajaxRenterLet.action",
								dataType : 'json',//从php返回的值以 JSON方式 解释 
								data : {
									"letInfo.renter.id" : renter_id
								},
								success : function(result) {
									console.log(result);
									var value = result.message;
									if (value == "success") {
										console.log(value);
									} else {
										console.log(value);
									}
									$("#addLet_letInfo_renter_personName").val(
											result.renter.personName);
								}
							});
						}

						$("#addLet_letInfo_broker_id").change(function() {
							ajaxLet_Broker();
						});

						function ajaxLet_Broker() {
							var broker_id = $("#addLet_letInfo_broker_id")
									.val();
							$.ajax({ //调用Ajax方法 
								type : "post", //以post方式与后台沟通 
								url : path + "/action/ajaxBrokerLet.action",
								dataType : 'json',//从php返回的值以 JSON方式 解释 
								data : {
									"letInfo.broker.id" : broker_id
								},
								success : function(result) {
									console.log(result);
									var value = result.message;
									if (value == "success") {
										console.log(value);
									} else {
										console.log(value);
									}
									$("#addLet_letInfo_broker_personName").val(
											result.broker.personName);
								}
							});
						}
						/* 				$("#addLet_0")
												.click(
														function() {
															//	$("#updatedLet").ajaxSubmit();

															$("#addLet")
																	.ajaxSubmit(
																			function(result) {
																				console
																						.log(result.message);
																				parent.location
																						.replace(parent.location.href);
																				var index = parent.layer
																						.getFrameIndex(window.name);
																				//	parent.$('.btn-refresh').click();
																				parent.layer
																						.close(index);
																			});
															return false; //阻止表单默认提交
														}); */

					});
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
			$("#addLet").ajaxSubmit(function(result) {
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
		$("#addLet").validate({
			rules : {
				"letInfo.letName" : {
					required : true,
					maxlength : 40
				},
				"letInfo.renter.id" : {
					required : true,
				},
				"letInfo.beginTime" : {
					required : true,
				},
				"letInfo.dayNum" : {
					required : true,
				},
				"letInfo.endTime" : {
					required : true,
				},
			}
		});
	});
</script>
</html>