<%--
  Created by IntelliJ IDEA.
  User: yangxueming
  Date: 2019/6/22
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8" />
    <title>微友圈</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <link rel="stylesheet" href="static/assets/css/reset.css" />
    <link rel="stylesheet" href="static/assets/css/animate.css" />
    <link rel="stylesheet" href="static/assets/css/swiper-3.4.1.min.css" />
    <link rel="stylesheet" href="static/assets/css/layout.css" />
    <link rel="stylesheet" href="static/assets/css/weui.css" />
    <link rel="stylesheet" href="static/assets/css/yuyin/index.css">
    <script src="static/assets/js/yuyin/recordmp3.min.js"></script>

    <script src="static/assets/js/jquery-1.12.4.js"></script>
    <script src="static/assets/js/zepto.min.js"></script>
    <script src="static/assets/js/fontSize.js"></script>
    <script src="static/assets/js/swiper-3.4.1.min.js"></script>
    <script src="static/assets/js/wcPop/wcPop.js"></script>
    <script src="static/assets/js/weui.min.js"></script>
    <script src="http://yx-web.nos.netease.com/official/websdk/NIM_Web_SDK_v4.8.0.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/RequestAjxa.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/main.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/onMsg.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/yuang.js"></script>
    <script type="text/javascript" src="/static/assets/js/service/saveChatList.js"></script>


</head>
<body>

<c:set var="dynamicDTOS" value="${dynamicDTOS}"></c:set>
<!-- <>微聊主容器 -->
<div class="wechat__panel clearfix">
    <div class="wc__home-wrapper flexbox flex__direction-column">
        <!-- //顶部 -->
        <div class="wc__headerBar fixed">
            <div class="inner flexbox">
                <a class="back splitline" href="javascript:;" onclick="history.back(-1);"></a>
                <h2 class="barTit flex1">微友圈</h2>
                <a href="addCircle">
                    <img src="https://i.52112.com/icon/jpg/256/20190218/30639/1518703.jpg" >
                </a>
                 </div>
        </div>
        <!-- //weiyouquan -->
        <div class="wc__friendZone">
            <div class="head">
                <img class="cover J__covers" id="backImg" src="" />
                <p class="uname" id="userName">张小龙</p>
                <a class="avator" href="#"><img id="userImg" src="" /></a>
            </div>
            <!-- //列表区 -->
            <div class="cont">
                <div class="inner">
                    <ul class="wc__cmtlist clearfix" id="J__cmtList">

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/assets/js/service/circle.js"></script>
<script type="text/javascript">

    yuang.init();  //初始化sdk
</script>

<script type="text/javascript">
    circle.init();
    /** __公共函数 */
    $(function(){
        // ...
    });

    /** __自定函数 */
    $(function(){
        // 赞封面
        $(".J__covers").on("click", function(){
            var coverIdx = wcPop({
                id: 'receivableIntro',
                skin: 'androidSheet',

                btns: [
                    {
                        text: '赞一下这个封面',
                        style: 'line-height: 50px;',
                        onTap() {
                            wcPop.close(coverIdx);
                        }
                    },
                ]
            });
        });


    });
</script>

</body>
</html>
