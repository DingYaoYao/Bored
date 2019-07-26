<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8" />
    <title>微聊</title>
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
    <script type='text/javascript' src='static/assets/js/huanxin/webim.config.js'></script>
    <script type='text/javascript' src='static/assets/js/huanxin/strophe-1.2.8.js'></script>
    <script type='text/javascript' src='static/assets/js/huanxin/websdk-1.4.13.js'></script>


</head>
<body>
<!-- <>微聊主容器 -->
<!-- <>微聊主容器 -->
<div class="wechat__panel clearfix">
    <div class="wc__home-wrapper flexbox flex__direction-column">
        <!-- //登录页面 -->
        <!-- //顶部 -->
        <div class="wc__headerBar fixed">
            <div class="inner flexbox">
                <a class="back splitline" href="javascript:;" onClick="history.back(-1);"></a>
                <h2 class="barTit flex1">添加朋友</h2>
            </div>
        </div>
        <div class="wc__lgregPanel flex1">
            <h2 class="hdtips">请输入好友账号</h2>
            <div class="forms">
                <form action="tianjiapengyou" method="post" id="lgregForms" >
                    <ul class="clearfix">
                        <li><label class="lbl flexbox"><em>账号:</em><input class="iptxt flex1" type="text" id="userNum" name="userNum" placeholder="请填写账号" /></label></li>
                    </ul>
                    <div class="lgway"></div>
                    <div class="btns"><a class="wc__btn-primary btn__login" id="my_sou" href="javascript:;">搜索</a></div>
                </form>
            </div>
        </div>
        <!-- //底部 -->
        <div class="wc__lgregFoot">
            <ul class="clearfix">

            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    // 登录验证
    $("#my_sou").on("click", function(){
        var userNum = $("#userNum").val();
        if(userNum == ''){
            wcPop({content: '用户名不能为空！', time: 2000});
        }else{
            $("#lgregForms").submit();
        }
    });
</script>
</html>
