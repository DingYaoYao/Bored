<%--
  Created by IntelliJ IDEA.
  User: yangxueming
  Date: 2019/7/8
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <h2 class="barTit flex1">详细资料</h2>
            </div>
        </div>

        <!-- //好友详细资料页 -->
        <div class="wc__ucinfoPanel">
            <div class="wc__ucinfo-detail">
                <ul class="clearfix" id="J__ucinfoPanel">
                    <li>
                        <div class="item flexbox flex-alignc wc__material-cell">
                            <img class="uimg" src="static/assets/img/uimg/${haoyou.headPortrait}" />
                            <label class="lbl flex1">
                                <em>${haoyou.remark==null?haoyou.nickname:remark}</em><i class="myfriend">${haoyou.userNum}</i>
                            </label>
                        </div>
                    </li>
                    <li>
                        <div class="item flexbox flex-alignc wc__material-cell">
                            <label class="lbl flex1">设置备注和标签</label>
                        </div>
                    </li>
                    <li>
                        <div class="item flexbox flex-alignc wc__material-cell">
                            <label class="lbl">地区</label>
                            <div class="cnt flex1 c-999">${haoyou.address}</div>
                        </div>
                        <div class="item flexbox flex-alignc wc__material-cell" routeUrl="weiyouquan.html">
                            <label class="lbl">个人相册</label>
                            <div class="cnt flex1">
                                <c:if test="${sayList!=null}">
                                    <c:forEach items="${sayList}" var="say">
                                        <c:if test="${say.image1!=null}">
                                            <img class="list-img" src="static/assets/img/placeholder/${say.image1}" />
                                        </c:if>
                                        <c:if test="${say.image2!=null}">
                                            <img class="list-img" src="static/assets/img/placeholder/${say.image2}" />
                                        </c:if>
                                        <c:if test="${say.image3!=null}">
                                            <img class="list-img" src="static/assets/img/placeholder/${say.image3}" />
                                        </c:if>
                                    </c:forEach>
                                </c:if>

                            </div>
                        </div>
                        <div class="item flexbox flex-alignc wc__material-cell">
                            <label class="lbl flex1">更多</label>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="wc__btns-panel">
                <a class="wc__btn-primary" href="toDanLiaoPage?friendId=${haoyou.userId}">发消息</a>
            </div>
        </div>

    </div>
</div>


<script type="text/javascript">
    /** __公共函数 */
    $(function(){
        // ...
    });

    /** __自定函数 */
    $(function(){
        // 跳转链接
        $(".wechat__panel").on("click", "*[routeUrl]", function (e) {
            var routeurl = $(this).attr('routeUrl');
            if (!routeurl) return;
            window.location.href = routeurl;
        });
    });
</script>
</body>
</html>

