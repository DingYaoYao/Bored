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
    <c:choose>
        <c:when test="${haoyouxinxi != null}">
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
                    <ul class="clearfix" >
                        <li>
                            <div class="item flexbox flex-alignc wc__material-cell">
                                <img class="uimg" src="static/assets/img/uimg/${haoyouxinxi.headPortrait}" />
                                <label class="lbl flex1">
                                    <em>${haoyouxinxi.remark==null?haoyouxinxi.nickname:remark}</em><i class="myfriend">${haoyouxinxi.userNum}</i>
                                </label>
                            </div>
                        </li>
                        <li>
                            <div class="item flexbox flex-alignc wc__material-cell">
                                <label class="lbl">地区</label>
                                <div class="cnt flex1 c-999">${haoyouxinxi.address}</div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="wc__btns-panel">
                    <a class="wc__btn-primary" href="javascript:void (0);">添加为好友</a>
                </div>
            </div>
        </div>
        </c:when>
        <c:otherwise>
        <div class="wc__home-wrapper flexbox flex__direction-column">
            <!-- //顶部 -->
            <div class="wc__headerBar fixed">
                <div class="inner flexbox">
                    <a class="back splitline" href="javascript:;" onclick="history.back(-1);"></a>
                    <h2 class="barTit flex1">暂无信息</h2>
                </div>
            </div>
            <!-- //好友详细资料页 -->
            <div class="wc__ucinfoPanel">
                <div class="wc__ucinfo-detail">
                    <ul class="clearfix">
                        <li>
                            <div class="item flexbox flex-alignc wc__material-cell">
                                <label class="lbl flex1">
                                    <em>未找到相关信息，请确认账号后重新搜索</em>
                                </label>
                            </div>
                        </li>
                    </ul>
                </div>

            </div>
        </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
<script type="text/javascript">
    var conn = null;
    $(function(){
        var options = {
            apiUrl: WebIM.config.apiURL,
            user: sessionStorage.getItem("userNum"),
            pwd: sessionStorage.getItem("password"),
            appKey: WebIM.config.appkey,
            success: function(msg) {
            },
            error: function(msg) {
                alert('###登录失败###');
            }

        };

        /** 环信集成*/
        //创建连接：开启IM连接
        conn = new WebIM.connection({
            isMultiLoginSessions: WebIM.config.isMultiLoginSessions,
            url: WebIM.config.xmppURL,
            heartBeatWait: WebIM.config.heartBeatWait,
            autoReconnectNumMax: WebIM.config.autoReconnectNumMax,
            autoReconnectInterval: WebIM.config.autoReconnectInterval,
            apiUrl: WebIM.config.apiURL,
            isAutoLogin: true
        });
        conn.open(options);
        conn.listen({
            onOpened: function(message) {
            },
            onPresence: function (message) {
                var myDate = new Date().toLocaleString();
                alert(myDate + JSON.stringify(message));
                switch (message.type) {
                    case 'subscribe': // 对方请求添加好友
                        var truthBeTold = window.confirm((message.from + "申请添加您为好友:"));
                        if (truthBeTold) {
                            // 同意对方添加好友
                            conn.subscribed({
                                to: message.from,
                                message: "[resp:true]"
                            });

                            alert("同意添加好友");
                        } else {
                            // 拒绝对方添加好友
                            conn.unsubscribed({
                                to: message.from,
                                message: "rejectAddFriend" // 拒绝添加好友回复信息
                            });
                            alert("拒绝添加好友");
                        }
                        break;
                    case 'subscribed': // 对方同意添加好友，已方同意添加好友
                        break;
                    case 'unsubscribe': // 对方删除好友
                        break;
                    case 'unsubscribed': // 被拒绝添加好友，或被对方删除好友成功
                        break;
                    case 'memberJoinPublicGroupSuccess': // 成功加入聊天室
                        alert('join chat room success' + myDate);
                        alert(new Date().toLocaleString());
                        break;
                    case 'joinChatRoomFaild': // 加入聊天室失败
                        alert('join chat room faild');
                        break;
                    case 'joinPublicGroupSuccess': // 意义待查
                        alert('join public group success', message.from);
                        break;
                    case 'createGroupACK':
                        conn.createGroupAsync({
                            from: message.from,
                            success: function (option){
                                alert('Create Group Succeed');
                            }
                        });
                        break;
                }
            },
            onClosed: function(message) {
                alert("关闭")
            }, //连接关闭回调
            //收到文本消息的回调

            onError: function(message) {alert(JSON.stringify(message));}, //失败回调
            onReceivedMessage: function(message) {}, //收到消息送达服务器回执
            onDeliveredMessage: function(message) {}, //收到消息送达客户端回执
            onReadMessage: function(message) {}, //收到消息已读回执
        });
    })

    $(".wc__btn-primary").on("click", function(){
        /** __公共函数 */
        var friendNum= $(".myfriend").text();
        conn.subscribe({
            to:friendNum
        });
        //$("#my_from").submit();
       // alert("发送好友申请成功");
    });
</script>

</html>

