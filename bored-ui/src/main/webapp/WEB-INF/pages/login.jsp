<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-touch-fullscreen" content="yes">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<link rel="stylesheet" href="static/assets/css/reset.css" />
	<link rel="stylesheet" href="static/assets/css/animate.css" />
	<link rel="stylesheet" href="static/assets/css/layout.css" />

	<script src="static/assets/js/jquery-1.9.1.min.js"></script>
	<script src="static/assets/js/zepto.min.js"></script>
	<script src="static/assets/js/fontSize.js"></script>
	<script src="static/assets/js/wcPop/wcPop.js"></script>
	<script type="text/javascript" src="static/assets/js/service/RequestAjxa.js"></script>

</head>
<body>

	<!-- <>微聊主容器 -->
	<div class="wechat__panel clearfix">
		<div class="wc__home-wrapper flexbox flex__direction-column">
			<!-- //登录页面 -->
			<div class="wc__lgregPanel flex1">
				<h2 class="hdtips">微聊号/邮箱登录</h2>
				<div class="forms">
					<form action="login" method="post" id="lgregForms" >
						<ul class="clearfix">
							<li><label class="lbl flexbox"><em>账号:</em><input class="iptxt flex1" type="text" id="userNum" name="userNum" placeholder="请填写微聊号" /></label></li>
							<li><label class="lbl flexbox"><em>密码:</em><input class="iptxt flex1" type="password" id="password" name="password" placeholder="请填写密码" /></label></li>
						</ul>
						<div class="lgway"><a href="register">注册账号</a></div>
						<div class="btns"><a class="wc__btn-primary btn__login" id="J__btnLogin" href="javascript:;">登录</a></div>
					</form>
				</div>
			</div>
			<!-- //底部 -->
			<div class="wc__lgregFoot">
				<ul class="clearfix">
					<li><a href="#">找回密码</a></li>
					<li><a href="#">更多</a></li>
				</ul>
			</div>
		</div>
	</div>

<script type="text/javascript" src="static/assets/js/service/login.js"></script>

</body>
</html>
