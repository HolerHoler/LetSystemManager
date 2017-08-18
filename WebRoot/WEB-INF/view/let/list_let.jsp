<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../include/meta.jsp"%>
<title>租约列表</title>
</head>
<body>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 租约管理 <span class="c-gray en">&gt;</span>
	租约列表 <a class="btn btn-success radius r"
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
				onclick="let_add('添加租约','jumpAddLet.action','800','500')"
				class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>
					添加租约
			</a> <a href="action/exportLet.action" class="btn btn-primary radius">
					<i class="Hui-iconfont">&#xe600;</i> 导出列表
			</a>
			</span>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr>
						<th scope="col" colspan="12">租约列表</th>
					</tr>
					<tr class="text-c">
						<th width="25px"><input type="checkbox" name="" value="">
						</th>
						<th width="50px">序号</th>
						<th width="50px">租约id</th>
						<th width="200px">租约名字</th>
						<th width="50px">房子id</th>
						<th width="100px">房子名字</th>
						<th width="50px">出租状态</th>
						<th width="50px">租客id</th>
						<th width="100px">租客姓名</th>
						<th width="50px">经纪人id</th>
						<th width="100px">经纪人姓名</th>
						<th width="100px">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="letList" var="let" status="stu">
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""></td>
							<td width="60"><s:property value="#stu.count" /></td>
							<td><s:a href="updateLet.action?LetID=%{#let.id}">
									<s:property value="#let.id" />
								</s:a></td>
							<td><s:property value="#let.letName" /></td>
							<td><s:a
									href="updateHouse.action?HouseID=%{#let.houseInfo.id}">
									<s:property value="#let.houseInfo.id" />
								</s:a></td>
							<td><s:property value="#let.houseInfo.houseName" /></td>
							<td><s:property value="#let.houseInfo.state" /></td>
							<td><s:a
									href="updateRenter.action?RenterID=%{#let.renter.id}">
									<s:property value="#let.renter.id" />
								</s:a></td>
							<td><s:property value="#let.renter.personName" /></td>
							<td><s:a
									href="updateBroker.action?BrokerID=%{#let.broker.id}">
									<s:property value="#let.broker.id" />
								</s:a></td>
							<td><s:property value="#let.broker.personName" /></td>
							<td class="td-manage"><s:a href="javascript:;"
									onclick="let_edit('编辑','updateLet.action?LetID=%{#let.id}','%{#let.id}','','510')"
									class="ml-5" style="text-decoration:none">修改</s:a> <s:a
									href="javascript:;"
									onclick="let_del(this,'deleteLet.action?LetID=%{#let.id}','1')">删除</s:a></td>
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

	function let_add(title, url, w, h) {
		layer_show(title, url, w, h);
	}

	/*租约-编辑*/
	function let_edit(title, url, id, w, h) {
		layer_show(title, url, w, h);
	}

	function let_del(obj, delurl, id) {
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