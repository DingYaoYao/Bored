<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <script type="text/javascript" src="static/assets/js/service/RequestAjxa.js"></script>
    <script type="text/javascript" src="static/assets/js/service/main.js"></script>


</head>
<body>

<!-- <>微聊主容器 -->
<div class="wechat__panel clearfix">
    <div class="wc__home-wrapper flexbox flex__direction-column">
        <!-- //顶部 -->
        <div class="wc__headerBar fixed">
            <div class="inner flexbox">
                <span id="userList"></span>
                <h2 class="barTit barTitLg flex1">微聊<em class="ff-ar">(12)</em></h2>
                <a class="barIco sear" href="javascript:;" id="J__topbarSear"></a>
                <a class="barIco add" href="javascript:;" id="J__topbarAdd"></a>
            </div>
        </div>

        <!-- //4个tabBar滑动切换 -->
        <div class="wc__swiper-tabBar flex1">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <!-- //1、）微聊主页-->
                    <div class="swiper-slide">
                        <div class="wc__scrolling-panel">
                            <!-- //聊天记录信息 -->
                            <div class="wc__recordChat-list" id="J__recordChatList">
                                <ul id="my_ul" class="clearfix">
                                    <c:forEach var="message" items="${chatMessages}">
                                        <c:forEach var="users" items="${userList}">
                                           <!--如果信息的接收人是当前登陆用户，并且根据信息表里查到的用户的id等于信息表的发送人id就得到了发送人的信息-->
                                            <c:if test="${message.receiver==user.userId&&users.userId==message.sendId}">
                                                <li id="my_li" class="flexbox wc__material-cell" routeUrl="toDanLiaoPage?friendId=${users.userId}">
                                                    <c:set var="str" value="static/assets/img/uimg/${users.headPortrait}"/>
                                                    <a href="toHaoYouXinXi?userNum=${users.userNum}"><div class="img"><img  src="${str}"/></div></a>
                                                    <div class="info flex1">
                                                        <h2 class="title">
                                                                ${users.remark==null?users.nickname:users.remark}
                                                        </h2>
                                                            <p class="desc clamp1" id="str${users.userNum}">${message.content}</p>
                                                    </div>

                                                    <label class="time" id="time${users.userNum}"><fmt:formatDate value="${message.messageDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></label>
                                                </li>
                                            </c:if>
                                            <c:if test="${message.sendId==user.userId&&users.userId==message.receiver}">
                                                <li id="my_li" class="flexbox wc__material-cell" routeUrl="toDanLiaoPage?friendId=${users.userId}">
                                                    <c:set var="str" value="static/assets/img/uimg/${users.headPortrait}"/>
                                                    <a href="toHaoYouXinXi?userNum=${users.userNum}"> <div class="img"><img src="${str}"/></div></a>
                                                    <div class="info flex1">
                                                        <h2 class="title">
                                                                ${users.remark==null?users.nickname:users.remark}
                                                        </h2>
                                                        <p class="desc clamp1" id="str${users.userNum}">${message.content}</p>
                                                    </div>
                                                    <label class="time" id="time${users.userNum}"><fmt:formatDate value="${message.messageDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></label>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- //2、通讯录-->
                    <div class="swiper-slide">
                        <div class="wc__scrolling-panel">
                            <div class="wc__addrFriend-list" id="J__addrFriendList">
                                <ul class="clearfix" id="my_txl">
                                    <li>
                                        <div class="row flexbox flex-alignc wc__material-cell">
                                            <img class="uimg" src="static/assets/img/icon__addrFriend-img01.jpg" /><span class="name flex1">新的朋友</span>
                                        </div>
                                        <div class="row flexbox flex-alignc wc__material-cell">
                                            <img class="uimg" src="static/assets/img/icon__addrFriend-img02.jpg" /><span class="name flex1">群聊</span>
                                        </div>
                                        <div class="row flexbox flex-alignc wc__material-cell">
                                            <img class="uimg" src="static/assets/img/icon__addrFriend-img03.jpg" /><span class="name flex1">标签</span>
                                        </div>
                                    </li>

                                </ul>
                            </div>
                        </div>
                        <!-- //字母显示 -->
                        <div class="wc__addrFriend-showletter">A</div>
                        <!-- //26字母 -->
                        <div class="wc__addrFriend-floatletter">
                            <em>A</em>
                            <em>B</em>
                            <em>C</em>
                            <em>D</em>
                            <em>E</em>
                            <em>F</em>
                            <em>G</em>
                            <em>H</em>
                            <em>I</em>
                            <em>J</em>
                            <em>K</em>
                            <em>L</em>
                            <em>M</em>
                            <em>N</em>
                            <em>O</em>
                            <em>P</em>
                            <em>Q</em>
                            <em>R</em>
                            <em>S</em>
                            <em>T</em>
                            <em>U</em>
                            <em>V</em>
                            <em>W</em>
                            <em>X</em>
                            <em>Y</em>
                            <em>Z</em>
                        </div>
                    </div>
                    <!-- //3、探索-->
                    <div class="swiper-slide">
                        <div class="wc__scrolling-panel">
                            <div class="wc__explore-list" id="J__exploreList">
                                <ul class="clearfix">
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell" routeUrl="toweiyouquan">
                                            <img class="icon" src="static/assets/img/icon__explore-img01.png" /><span class="txt flex1">朋友圈</span><div class="notice wc__arr"><img src="static/assets/img/uimg/u__chat-img14.jpg" /><em class="wc__badge wc__badge-dot"></em></div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="icon" src="static/assets/img/icon__explore-img02.png" /><span class="txt flex1">看一看</span>
                                        </div>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="icon" src="static/assets/img/icon__explore-img03.png" /><span class="txt flex1">找一找</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="icon" src="static/assets/img/icon__explore-img04.png" /><span class="txt flex1">小心跳</span>
                                        </div>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="icon" src="static/assets/img/icon__explore-img05.png" /><span class="txt flex1">好友力</span><span class="fs-20 ff-vd c-ccc mt-5">^-^测测您和谁最能聊</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- //4、我-->
                    <div class="swiper-slide">
                        <div class="wc__scrolling-panel">
                            <div class="wc__ucenter-list" id="J__ucenterList">
                                <ul class="clearfix">
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell" routeUrl="gerenxinxi.html">
                                            <img class="uimg" src="static/assets/img/uimg/${user.headPortrait}" />
                                            <span class="txt flex1">
													<em>${user.nickname}</em><i>${user.userNum}</i>
												</span>
                                            <div class="qrcode wc__arr"><img src="static/assets/img/placeholder/u__qrcode-img.png" /></div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell" routeUrl="#">
                                            <img class="icon" src="<%--<%=session.getServletContext().getRealPath("static/assets/img")%>--%>static/assets/img/icon__uc-img01.png" /><span class="txt flex1">钱包</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="icon" src="static/assets/img/icon__uc-img02.png" /><span class="txt flex1">收藏</span>
                                        </div>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="icon" src="static/assets/img/icon__uc-img03.png" /><span class="txt flex1">相册</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="item flexbox flex-alignc wc__material-cell">
                                            <img class="icon" src="static/assets/img/icon__uc-img04.png" /><span class="txt flex1">设置</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- //底部tabbar -->
        <div class="wechat__tabBar">
            <div class="bottomfixed wc__borT">
                <ul class="flexbox flex-alignc wechat-pagination">
                    <li class="flex1 on"><i class="ico i1"><em class="wc__badge">12</em></i><span>微聊</span></li>
                    <li class="flex1" id="txl"><i class="ico i2"></i><span>通讯录</span></li>
                    <li class="flex1"><i class="ico i3"><em class="wc__badge wc__badge-dot"></em></i><span>探索</span></li>
                    <li class="flex1"><i class="ico i4"></i><span>我</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>


<!-- …… 顶部快捷弹窗.Start -->
<div class="wc__popup-topbar" id="J__popupTopBar">
    <div class="wrap__topbar-mask"></div>
    <div class="wrap__topbar-menu">
        <ul class="clearfix animated anim-zoomInDownSmall">
            <li class="wc__material-cell"><i class="ico i1"></i><span>发起群聊</span></li>
            <li class="wc__material-cell"><a href="toTianJiaPengYouPage"><i class="ico i2"></i><span>添加朋友</span></a></li>
            <li class="wc__material-cell"><i class="ico i3"></i><span>帮助与反馈</span></li>
        </ul>
    </div>
</div>

<script type="text/javascript">
main.init();
</script>

<!-- 左右滑屏切换.Start -->
<script type="text/javascript">
    var Swiper = new Swiper('.swiper-container',{
        pagination: '.wechat-pagination',
        slidesPerView: 'auto',
        centeredSlides: true,
        paginationClickable: true,
        paginationBulletRender: function (Swiper, index, className) {
            switch (index) {
                case 0:
                    name='<i class="ico i1"><em class="wc__badge">12</em></i><span>微聊</span>';
                    break;
                case 1:
                    name='<i class="ico i2"></i><span>通讯录</span>';
                    break;
                case 2:
                    name='<i class="ico i3"><em class="wc__badge wc__badge-dot"></em></i><span>探索</span>';
                    break;
                case 3:
                    name='<i class="ico i4"></i><span>我</span>';
                    break;
                default: name='';
            }
            return '<li class="flex1 ' + className + '">' + name + '</li>';
        }
    });
    /**通讯录点击事件*/
    $(".wechat-pagination").on("click","li",function(){
    })
</script>
<!-- 左右滑屏切换 end -->
<script type="text/javascript">

    $(function(){
        /** __公共函数 */
        var conn = null;
        var options = {
            apiUrl: WebIM.config.apiURL,
            user: sessionStorage.getItem("userNum"),
            pwd: sessionStorage.getItem("password"),
            appKey: WebIM.config.appkey,
            success: function(msg) {
            },
            error: function(msg) {
               // alert('###登录失败###');
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
        //该设置为手动上线
        //conn.setPresence();
        //回调函数：开启监听（精简过后的代码）
        sessionStorage.setItem("conn",JSON.stringify(conn));
        conn.listen({
            onOpened: function(message) {
            },
            onPresence: function (message) {
                var myDate = new Date().toLocaleString();
             //   alert(myDate + JSON.stringify(message));
                switch (message.type) {
                    case 'subscribe': // 对方请求添加好友
                        var truthBeTold = window.confirm((message.from + "申请添加您为好友:"));
                        if (truthBeTold) {
                            // 同意对方添加好友
                            conn.subscribed({
                                to: message.from,
                                message: "[resp:true]"
                            });

                           // alert("同意添加好友");
                        } else {
                            // 拒绝对方添加好友
                            conn.unsubscribed({
                                to: message.from,
                                message: "rejectAddFriend" // 拒绝添加好友回复信息
                            });
                        //    alert("拒绝添加好友");
                        }
                        break;
                    case 'subscribed': // 对方同意添加好友，已方同意添加好友
                        break;
                    case 'unsubscribe': // 对方删除好友
                        break;
                    case 'unsubscribed': // 被拒绝添加好友，或被对方删除好友成功
                        break;
                    case 'memberJoinPublicGroupSuccess': // 成功加入聊天室
                       // alert('join chat room success' + myDate);
                   //     alert(new Date().toLocaleString());
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
            onTextMessage: function(message) {
                alert(message.sourceMsg);
                var friendId=message.from;
                var messagestr=message.sourceMsg;
                $.ajax({
                    url: "findUserById",
                    data: {"userNum":friendId},
                    type:"get",
                    dataType:"json",
                    success: function (friend){
                       // alert(friend.userNum);
                        var list=<%=session.getAttribute("jsonlist")%>;
                     //   alert(list);
                        var flag=false;
                        for(var p in list){//遍历json数组时，这么写p为索引，0,1
                            alert(list[p].userNum);
                            if (list[p].userNum==friendId){
                                flag=true;
                            };
                        };
                        if (flag){
                            var $chatMsgList = $("#J__chatMsgList");
                            var html=messagestr.replace('<p>','');
                            var htmlstr=html.replace('</p>','');
                            htmlstr=htmlstr.trim();
                            $("#time"+friendId).replaceWith("<label class='time' id='time${friend.userNum}'>"+message.delay+"</label>");
                            $("#str"+friendId).replaceWith('<p class="desc clamp1 id='+friend.userNum+'">'+htmlstr+'</p>');
                        }else{
                            var ul=$("#my_ul");//得到ul
                            var str="static/assets/img/uimg/"+friend.headPortrait+"";//头像路径
                            var name=friend.remark==null?friend.nickname:friend.remark;
                            var html=[
                                '<li class="flexbox wc__material-cell" routeUrl="toDanLiaoPage?friendId='+friend.userNum+'">\
                             <div class="img"><img src="'+str+'"/></div>\
                             <div class="info flex1">\
                             <h2 class="title"> '+name+'</h2>\
                            <p class="desc clamp1 "id="str'+friend.userNum+'">'+messagestr+'</p>\
                             </div>\
                              <label class="time" id="time${users.userNum}">'+message.delay+'</label>\
                          </li>'].join("");
                            ul.append(html);
                        }



                    }, error: function (jqXHR, textStatus, errorThrown) {
                    }
                });

            }, //收到文本消息
            onError: function(message) {
                //alert(JSON.stringify(message));
                }, //失败回调
            onReceivedMessage: function(message) {}, //收到消息送达服务器回执
            onDeliveredMessage: function(message) {}, //收到消息送达客户端回执
            onReadMessage: function(message) {}, //收到消息已读回执
        });
        //easemobwebim-sdk中收到联系人订阅请求的处理方法，具体的type值所对应的值请参考xmpp协议规范
    });


    /** __自定函数 */
        // 顶部添加按钮
        $(".wc__headerBar").on("click", "#J__topbarAdd", function () {
            $("#J__popupTopBar").show();
        });
        $("#J__popupTopBar").on("click", ".wrap__topbar-mask", function () {
            $(this).parent().hide();
        });
        // 禁止长按弹出系统菜单
        $(".wechat__panel").on("contextmenu", function(e){
            e.preventDefault();
        });
        //***1、微聊-------------------------
        // 聊天记录页面（长按操作）
        $("#J__recordChatList").on("longTap", "li", function(e){
            var _this = $(this);
            wcPop({
                skin: 'androidSheet',
                shadeClose: true,

                btns: [
                    {text: '标为未读', style: 'line-height:50px;'},
                    {text: '置顶聊天', style: 'line-height:50px;'},
                    {
                        text: '删除该聊天',
                        style: 'line-height:50px;',
                        onTap() {
                            wcPop({
                                skin: 'android',
                                content: '删除后，将会清空该聊天记录',

                                btns: [
                                    {
                                        text: '取消',
                                        onTap() {
                                            wcPop.close();
                                        }
                                    },
                                    {
                                        text: '删除',
                                        style: 'color:#ffba00',
                                        onTap() {
                                            _this.remove();
                                            wcPop.close();
                                        }
                                    }
                                ]
                            });
                        }
                    }
                ]
            });
        });
        // 跳转链接
        $(".wechat__panel").on("click", "*[routeUrl]", function(e){
            var routeurl = $(this).attr('routeUrl');
            if(!routeurl) return;
            window.location.href = routeurl;
        });

        //***2、通讯录-------------------------
        // 右侧浮动条
        $(".wc__addrFriend-floatletter").on("click", "em", function() {
            var letter = $(this).text();
            if($("#" + letter).length > 0){
                // 滚动到指定位置
                //$("#J__addrFriendList").parent().animate({ scrollTop: $("#" + letter).position().top}, 300);
                document.getElementById(letter).scrollIntoView();
            }
            $(".wc__addrFriend-showletter").text(letter).fadeIn(300);

            setTimeout(function(){
                $(".wc__addrFriend-showletter").fadeOut(300);
            }, 500);
        });

        // 通讯录（长按操作）
        $("#J__addrFriendList li:not(:first-child)").on("longTap", ".row", function(e){
            var _this = $(this);
            wcPop({
                skin: 'androidSheet',
                shadeClose: true,

                btns: [
                    {
                        text: '设置备注及标签',
                        style: 'line-height:50px;',
                        onTap() {
                            wcPop.close();
                        }
                    }
                ]
            });
        });
</script>

</body>
</html>
