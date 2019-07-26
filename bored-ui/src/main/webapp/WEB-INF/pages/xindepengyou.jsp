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
<div class="wechat__panel clearfix">
            <div class="wc__home-wrapper flexbox flex__direction-column">
                <!-- //顶部 -->
                <div class="wc__headerBar fixed">
                    <div class="inner flexbox">
                        <a class="back splitline" href="javascript:;" onclick="history.back(-1);"></a>
                        <h2 class="barTit flex1">好友请求</h2>
                    </div>
                </div>
                <!-- //好友详细资料页 -->
                <div class="wc__ucinfoPanel">
                    <div class="wc__ucinfo-detail">
                        <span>对方请求添加你为好友</span>
                        <ul class="clearfix" >
                            <li>
                                <div class="item flexbox flex-alignc wc__material-cell">
                                    <img class="uimg" src="static/assets/img/uimg/${haoyouqingqiu.headPortrait}" />
                                    <label class="lbl flex1">
                                        <em>${haoyouqingqiu.remark==null?haoyouqingqiu.nickname:remark}</em><i>${haoyouqingqiu.userNum}</i>
                                    </label>
                                </div>
                            </li>
                            <li>
                                <div class="item flexbox flex-alignc wc__material-cell">
                                    <label class="lbl">地区</label>
                                    <div class="cnt flex1 c-999">${haoyouqingqiu.address}</div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="wc__btns-panel">
                        <a class="wc__btn-primary" href="consent?userNum=${haoyouxinxi.userNum}">通过验证</a>
                    </div>
                </div>
            </div>
</div>

</body>
</html>
