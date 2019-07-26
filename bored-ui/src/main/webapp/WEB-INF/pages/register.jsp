<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8" />
    <title>注册</title>
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
    <script type='text/javascript' src='static/assets/js/huanxin/webim.config.js'></script>
    <script type='text/javascript' src='static/assets/js/huanxin/strophe-1.2.8.js'></script>
    <script type='text/javascript' src='static/assets/js/huanxin/websdk-1.4.13.js'></script>

</head>
<body>

<!-- <>微聊主容器 -->
<div class="wechat__panel clearfix">
    <div class="wc__home-wrapper flexbox flex__direction-column">
        <!-- //登录页面 -->
        <div class="wc__lgregPanel flex1">
            <br/>
            <br/>
            <a href="login"><sapn style="font-size: 0.3rem ;color: #0060a0">&nbsp;&nbsp;&nbsp;返回登陆</sapn></a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="hdtips">微聊号注册</span>
<br><br><br><br><br>
            <div class="forms">
                <form action="register" method="post" id="lgregForms" >
                    <ul class="clearfix">
                        <li><label class="lbl flexbox"><em>手机号:</em><input class="iptxt flex1" type="text" id="phone" name="phone" placeholder="请输入手机号！" /></label></li>

                        <li><label class="lbl flexbox"><em>昵称:</em><input class="iptxt flex1" type="text" id="nickname" name="nickname" placeholder="请填写昵称！" /></label></li>
                        <li><label class="lbl flexbox"><em>密码:</em><input class="iptxt flex1" type="password" id="password" name="password" placeholder="请设置密码！" /></label></li>

                        <br/>
                        <li id="accId" style="display:none">
                            <label class="lbl flexbox">
                                <span>你的账号为:</span>
                                <input class="iptxt flex1" type="text" id="userNum" value="" name="userNum"  />
                            </label>
                        </li>
                    </ul>
                    <div class="lgway"><a href="javascript:;"></a></div>
                    <div class="btns"><a id="register" class="wc__btn-primary btn__login" href="javascript:;">注册</a></div>
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

<script type="text/javascript" src="static/assets/js/service/register.js"></script>
<script type="text/javascript" src="static/assets/js/service/RequestAjxa.js"></script>
</body>
</html>
