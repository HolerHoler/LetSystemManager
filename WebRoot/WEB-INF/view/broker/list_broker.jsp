<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../include/meta.jsp"%>
<title>经纪人列表</title>
</head>
<body>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 经纪人管理 <span class="c-gray en">&gt;</span>
	经纪人列表 <a class="btn btn-success radius r"
		style="line-height:1.6em;margin-top:3px"
		href="javascript:location.replace(location.href);" title="刷新"> <i
		class="Hui-iconfont">&#xe68f;</i>
	</a></nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"> <a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"> <i class="Hui-iconfont">&#xe6e2;</i>
					批量删除
			</a> <a href="javascript:;"
				onclick="broker_add('添加经纪人','jumpAddBroker.action','800','500')"
				class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>
					添加经纪人
			</a> <a href="action/exportBroker.action" class="btn btn-primary radius">
					<i class="Hui-iconfont">&#xe600;</i> 导出列表
			</a>
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25px"><input type="checkbox" name="" value="">
						</th>
						<th width="25px">序号</th>
						<th width="50px">证件类型</th>
						<th width="200px">证件号码</th>
						<th width="100px">经纪人姓名</th>
						<th width="100px">经纪人联系方式</th>
						<th width="150px">工作地址</th>
						<th width="100px">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="brokerList" var="broker" status="stu">
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""></td>
							<td><s:property value="#stu.count" /></td>
							<td><s:property value="#broker.credentials_type" /></td>
							<td><s:property value="#broker.credentials_id" /></td>
							<td><s:property value="#broker.personName" /></td>
							<td><s:property value="#broker.telephone" /></td>
							<td><s:property value="#broker.work_address" /></td>
							<td class="td-manage"><s:a href="javascript:;"
									onclick="broker_edit('编辑','updateBroker.action?BrokerID=%{#broker.id}','%{#broker.id}','','510')"
									class="ml-5" style="text-decoration:none">修改</s:a> <s:a
									href="javascript:;"
									onclick="broker_del(this,'deleteBroker.action?BrokerID=%{#broker.id}','1')">删除</s:a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/3rd_lib/datatables/1.10.0/jquery.dataTables.js"></script>
<script type="text/javascript">
	$('.table-sort').dataTable({
		"asSorting" : [ [ 2, "asc" ] ],//默认第几个排序
		"bStateSave" : true,//状态保存
	});

	function broker_add(title, url, w, h) {
		layer_show(title, url, w, h);
	}

	/*经纪人-编辑*/
	function broker_edit(title, url, id, w, h) {
		layer_show(title, url, w, h);
	}

	function broker_del(obj, delurl, id) {
		layer.confirm('您是否删除本记录？', {
			btn : [ '是', '取消' ]
		//按钮
		}, function() {
			$.ajax({
				type : 'POST',
				url : delurl,
				dataType : 'json',
				success : function(data) {
					console.log(111);
					location.replace(location.href);
				},
				error : function(data) {
					console.log(222);
				},
			});
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			});

		}, function() {
			layer.msg('已取消!', {
				icon : 1,
				time : 1000
			});

		});
	}
</script>
</html>