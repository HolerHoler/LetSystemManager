<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs" href="#">出租屋管理系统</a>
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"
				href="javascript:;">&#xe667;</a>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<li>超级管理员</li>
					<li class="dropDown dropDown_hover"><a href="#"
						class="dropDown_A"><s:property value="user.username" /> <i
							class="Hui-iconfont">&#xe6d5;</i> </a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
							<li><a href="javascript:;"
								onClick="exitLogin('exitLogin.action')">切换账户</a></li>
							<li><a href="javascript:;"
								onClick="exitLogin('exitLogin.action')">退出</a></li>
						</ul></li>
					<li id="Hui-msg"><a href="#" title="消息"> <span
							class="badge badge-danger">1</span> <i class="Hui-iconfont"
							style="font-size:18px">&#xe68a;</i>
					</a></li>
					<li id="Hui-skin" class="dropDown right dropDown_hover"><a
						href="javascript:;" class="dropDown_A" title="换肤"> <i
							class="Hui-iconfont" style="font-size:18px">&#xe62a;</i>
					</a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a>
							</li>
							<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a>
							</li>
							<li><a href="javascript:;" data-val="green" title="绿色">绿色</a>
							</li>
							<li><a href="javascript:;" data-val="red" title="红色">红色</a>
							</li>
							<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
							</li>
							<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a>
							</li>
						</ul></li>
				</ul>
			</nav>
		</div>
	</div>
</header>
<script type="text/javascript">
	function exitLogin(delurl) {
		layer.confirm('您是否确认退出本系统？', {
			btn : [ '是', '取消' ]
		//按钮
		}, function() {
			$.ajax({
				type : 'POST',
				url : delurl,
				dataType : 'json',
				success : function(data) {
					console.log(111);
				},
				error : function(data) {
					console.log(222);
				},
			});
			layer.msg('退出成功!', {
				icon : 1,
				time : 1000
			});
			window.location.href = "/LetSystemManager/login.jsp";
		}, function() {
			layer.msg('已取消!', {
				icon : 1,
				time : 1000
			});

		});
	}
</script>

