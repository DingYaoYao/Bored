<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8" />
	<title>详细资料</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-touch-fullscreen" content="yes">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<link rel="stylesheet" href="static/assets/css/reset.css" />
	<link rel="stylesheet" href="static/assets/css/animate.css" />
	<link rel="stylesheet" href="static/assets/css/swiper-3.4.1.min.css" />
	<link rel="stylesheet" href="static/assets/css/layout.css" />

	<script src="static/assets/js/jquery-1.9.1.min.js"></script>
	<script src="static/assets/js/zepto.min.js"></script>
	<script src="static/assets/js/fontSize.js"></script>
	<script src="static/assets/js/swiper-3.4.1.min.js"></script>
	<script src="static/assets/js/wcPop/wcPop.js"></script>

	<script src="http://yx-web.nos.netease.com/official/websdk/NIM_Web_SDK_v4.8.0.js"></script>
	<script type="text/javascript" src="/static/assets/js/service/RequestAjxa.js"></script>
	<script type="text/javascript" src="/static/assets/js/service/main.js"></script>
	<script type="text/javascript" src="/static/assets/js/service/onMsg.js"></script>
	<script type="text/javascript" src="/static/assets/js/service/yuang.js"></script>
	<script type="text/javascript" src="/static/assets/js/service/saveChatList.js"></script>




</head>
<body>

	<!-- <>微聊主容器 -->
	<div class="wechat__panel clearfix">
		<div class="wc__home-wrapper flexbox flex__direction-column">
			<!-- //顶部 -->
			<div class="wc__headerBar fixed">
				<div class="inner flexbox">
					<a class="back splitline" href="javascript:;" onclick="history.back(-1);"></a>
					<h2 class="barTit flex1">个人信息</h2>
				</div>
			</div>

			<!-- //个人信息页 -->
			<div class="wc__ucinfoPanel">
				<div class="wc__ucinfo-personal">
					<ul class="clearfix">
						<li>
							<div class="item flexbox flex-alignc wc__material-cell">
								<label class="lbl flex1">头像</label>
								<img class="uimg" src="" id="userPic" />
								<input class="chooseImg" type="file" accept="image/*" />
							</div>
							<div class="item flexbox flex-alignc wc__material-cell">
								<label class="lbl flex1">昵称</label>
								<div class="val" id="userName">Andy</div>
							</div>
							<div class="item flexbox flex-alignc wc__material-cell">
								<label class="lbl flex1">微聊号</label>
								<div class="val" id="userId">jackson007</div>
							</div>
							<div class="item flexbox flex-alignc wc__material-cell">
								<label class="lbl flex1">更多</label>
							</div>
						</li>
						<li>
							<div class="item flexbox flex-alignc wc__material-cell">
								<label class="lbl flex1">我的地址</label>
								<div class="val" id="address">jackson007</div>
							</div>
						</li>
					</ul>
				</div>
			</div>

		</div>
	</div>


	<script type="text/javascript">


				yuang.init();  //初始化sdk

		$("#userPic").attr("src",bored.userInfo.picturepath);
		$("#address").html(bored.userInfo.addressId);
		$("#userId").html(bored.userInfo.id);
		$("#userName").html(bored.userInfo.nicename);
		/** __公共函数 */
		$(function(){
			// ...
		});

		/** __自定函数 */
		$(function(){
			// ...
		});
	</script>

</body>
</html>
