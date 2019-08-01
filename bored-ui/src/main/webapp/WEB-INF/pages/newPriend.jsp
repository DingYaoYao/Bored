<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8" />
    <title>新朋友</title>
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

    <script type="text/javascript" src="static/assets/js/service/RequestAjxa.js"></script>
    <script type="text/javascript" src="static/assets/js/service/newPriends.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/saveChatList.js"></script>
    <script src="http://yx-web.nos.netease.com/official/websdk/NIM_Web_SDK_v4.8.0.js"></script>
   <script type="text/javascript" src="/static/assets/js/service/main.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/onMsg.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/yuang.js"></script>


</head>
<body>

<div class="wechat__panel clearfix">
            <div class="wc__home-wrapper flexbox flex__direction-column">
                <!-- //顶部 -->
                <div class="wc__headerBar fixed">
                    <div class="inner flexbox">
                        <a class="back splitline" href="javascript:;" onclick="history.back(-1);"></a>
                        <h2 class="barTit flex1">好友请求</h2>
                    </div>
                </div>

                <div class="wc__home-wrapper flexbox flex__direction-column">
                    <!-- //好友详细资料页 -->
                    <div id="user_info"  class="wc__ucinfoPanel">
                        <div class="wc__ucinfo-detail">
                            <ul class="clearfix" id="newPriends">

                            </ul>
                        </div>

                    </div>
                </div>



            </div>
</div>
<script type="text/javascript">
    newPriends.init();
    yuang.init();
</script>
</body>
</html>
