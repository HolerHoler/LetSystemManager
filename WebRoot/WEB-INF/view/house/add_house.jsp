<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../include/meta.jsp"%>
<%@ page isELIgnored="false"%>
<title>添加房子</title>
</head>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
<body>
	<article class="page-container"> <s:form namespace="/action"
		action="addHouse" class="form form-horizontal" method="post">

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子名字：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.houseName" label="房子名字" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <s:select label="房子类型"
						headerKey="0" headerValue="请选择" class="select"
						list="#{'普通':'1-普通', '别墅':'2-别墅'}" name="house.type" listKey="key"
						listValue="value" />
				</span>
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子设计：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.design" label="房子设计" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子朝向：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.direction" label="房子朝向" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子大小(㎡)：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.size" label="房子大小(㎡)" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.address" label="房子地址" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子所在楼层：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.floor" label="房子所在楼层" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子租金（元/月）：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.rent" label="房子租金" class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>租房方式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.rent_method" label="租房方式"
					class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>租房要求：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textfield name="house.rent_remand" label="租房要求"
					class="input-text" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子装修：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <s:select label="房子装修"
						headerKey="0" headerValue="请选择" class="select"
						list="#{'豪华':'1-豪华装修', '精美':'2-精装修','普通':'3-普通装修','未':'4-未装修'}"
						name="house.decoration" listKey="key" listValue="value" />
				</span>
			</div>
		</div>


		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子配套：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:checkboxlist label="配套" list="#{'电视':'电视','空调':'空调','家具':'家具'}"
					listKey="key" listValue="value" name="house.facilities" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<s:textarea name="house.description" label="房子描述" cols="30" rows="8"
					class="textarea" />
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>房子状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box"> <s:select label="房子状态"
						class="select" headerKey="0" headerValue="请选择"
						list="#{'Y':'1-已出租', 'N':'2-未出租'}" name="house.state"
						listKey="key" listValue="value" value="{'N'}" /></span>
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<!-- <input type="button" id="addHouse_0" value="增加"
					class="btn btn-primary radius" /> -->
				<input class="btn btn-primary radius" type="submit" value="提交">
			</div>
		</div>



		<%-- 		<s:textfield name="house.houseName" label="房子名字" />
		<s:select label="房子类型" headerKey="0" headerValue="请选择证件类型"
			list="#{'普通':'1-普通', '别墅':'2-别墅'}" name="house.type" listKey="key"
			listValue="value" />
		<s:textfield name="house.design" label="房子设计" />
		<s:textfield name="house.direction" label="房子朝向" />
		<s:textfield name="house.size" label="房子大小(㎡)" />
		<s:textfield name="house.address" label="房子地址" />
		<s:textfield name="house.floor" label="房子所在楼诚" />
		<s:textfield name="house.rent" label="房子租金" />
		<s:textfield name="house.rent_method" label="租房方式" />
		<s:textfield name="house.rent_remand" label="租房要求" />
		<s:select label="房子装修" headerKey="0" headerValue="请选择装修类型"
			list="#{'豪华':'1-豪华装修', '精美':'2-精装修','普通':'3-普通装修','未':'4-未装修'}"
			name="house.decoration" listKey="key" listValue="value" />
		<s:checkboxlist label="配套" list="#{'电视':'电视','空调':'空调','家具':'家具'}"
			listKey="key" listValue="value" name="house.facilities" />
		<s:textarea name="house.description" label="房子描述" cols="30" rows="8" />
		<s:select label="房子状态" headerKey="0" headerValue="请选择装修类型"
			list="#{'Y':'1-已出租', 'N':'2-未出租'}" name="house.state" listKey="key"
			listValue="value" value="{'N'}" />
		<s:submit value="添加" /> --%>
	</s:form> </article>
</body>
<%-- <script type="text/javascript">
	$(document).ready(function() {
		$("#addHouse_0").click(function() {
			//	$("#updatedLet").ajaxSubmit();

			$("#addHouse").ajaxSubmit(function(result) {
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
	$.validator.setDefaults({
		submitHandler : function() {
			$("#addHouse").ajaxSubmit(function(result) {
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
		$("#addHouse").validate({
			rules : {
				"house.houseName" : {
					required : true,
					maxlength : 40
				},
				"house.design" : {
					required : true,
					maxlength : 10
				},
				"house.type" : {
					required : true,
					maxlength : 10
				},
				"house.size" : {
					required : true,
					number : true,
					min : 0
				},
				"house.design" : {
					required : true,
					maxlength : 10
				},
				"house.rent" : {
					required : true,
					number : true,
					min : 0
				},
				"house.rent_method" : {
					required : true,
					maxlength : 4
				},
				"house.rent_remand" : {
					required : true,
					maxlength : 4
				},
				"house.direction" : {
					required : true,
					maxlength : 4
				},
				"house.address" : {
					required : true,
					maxlength : 40
				},
				"house.floor" : {
					required : true,
					maxlength : 8
				},
				"house.decoration" : {
					required : true,
					maxlength : 8
				},
				"house.description" : {
					maxlength : 200
				}
			},
		});
	});
</script>
</html>