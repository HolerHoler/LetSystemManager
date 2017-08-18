<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<%@ include file="include/meta.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/h-ui.admin/skin/green/skin.css"
	id="skin" />

<title>admin</title>

</head>
<script type="text/javascript">
	if (top.location != self.location) {
		top.location = self.location;
	}
</script>

<%-- <frameset cols="15%,*" bordercolor="#FF00FF">
	<frame src="<jsp:forward page="/WEB-INF/view/menu.jsp" />" noresize />
	<frame src="<jsp:forward page="/WEB-INF/view/menu.jsp" />"
		scrolling="auto" border="1" name="show">
</frameset> --%>
<body>
	<%@ include file="include/_header.jsp"%>
	<%@ include file="include/_menu.jsp"%>


	<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span>
					<em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group">
			<a id="js-tabNav-prev" class="btn radius btn-default size-S"
				href="javascript:;"> <i class="Hui-iconfont">&#xe6d4;</i>
			</a> <a id="js-tabNav-next" class="btn radius btn-default size-S"
				href="javascript:;"> <i class="Hui-iconfont">&#xe6d7;</i>
			</a>
		</div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="../welcome.jsp">
			</iframe>
		</div>
	</div>
	</section>
	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前</li>
			<li id="closeall">关闭全部</li>
		</ul>
	</div>

</body>

</html>