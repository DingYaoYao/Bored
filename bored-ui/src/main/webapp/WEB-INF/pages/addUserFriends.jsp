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
                <a class="back splitline" href="javascript:;" onClick="history.back(-1);"></a>
                <h2 class="barTit flex1">添加朋友</h2>
            </div>
        </div>
        <div class="wc__lgregPanel flex1">
            <%--<h2 class="hdtips">请输入好友账号</h2>--%>
            <div class="forms">
                <form action="#"  >
                    <ul class="clearfix">
                        <li><label class="lbl flexbox"><em>账号:</em>
                            <input  class="iptxt flex1" style="width: 90%;" type="text" id="userNum" placeholder="请填写账号" />
                            <a href="javascript:searchUser()">
                                <img  id="search" src="https://i.52112.com/icon/jpg/256/20190531/42121/1979962.jpg">
                            </a>
                            </label></li>
                    </ul>
                    <div class="lgway" ></div>
                    <%--<div class="btns"><a class="wc__btn-primary btn__login" id="my_sou" href="javascript:;">搜索</a></div>--%>
                </form>
            </div>
        </div>



                    <div class="wc__home-wrapper flexbox flex__direction-column">
                        <!-- //好友详细资料页 -->
                        <div id="user_info" style="display: none" class="wc__ucinfoPanel">
                            <div class="wc__ucinfo-detail">
                                <ul class="clearfix" >
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="uimg" src="#"  id="searchImg"/>
                                            <label class="lbl flex1">
                                                <em id="searchName"></em><i id="searchId"></i>
                                            </label>
                                        </div>
                                    </li>
                                    <li>
                                        <%--wc__material-cell--%>
                                        <div class="item flexbox flex-alignc ">
                                            <label class="lbl">备注</label>
                                            <input style="border: none;"  class="iptxt flex1" type="text" id="remark"/>
                                            <div class="cnt flex1 c-999" ></div>
                                        </div>
                                    </li>
                                    <li>
                                        <%--wc__material-cell--%>
                                        <div class="item flexbox flex-alignc ">
                                            <label class="lbl">附加消息</label>
                                            <input style="border: none;"  class="iptxt flex1" type="text" id="common"/>
                                            <div class="cnt flex1 c-999" ></div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="item flexbox flex-alignc ">
                                            <label class="lbl">地区</label>
                                            <div class="cnt flex1 c-999" id="searchAddress"></div>
                                        </div>
                                    </li>

                                </ul>
                            </div>
                            <div class="wc__btns-panel">
                                <a class="wc__btn-primary" href="javascript:addUserFriend();">添加为好友</a>
                            </div>
                        </div>

                        <!-- 没有好友显示 -->
                        <div  id="not_user"style="display: none" class="wc__ucinfoPanel">
                            <div class="wc__ucinfo-detail">
                                <ul class="clearfix">
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <label class="lbl flex1">
                                                <em>未找到相关信息，请确认账号后重新搜索!</em>
                                            </label>
                                        </div>
                                    </li>
                                </ul>
                            </div>

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
<script type="text/javascript" src="static/assets/js/service/searchUserFriends.js"></script>
<script type="text/javascript">

    yuang.init();  //初始化sdk
</script>
</html>
