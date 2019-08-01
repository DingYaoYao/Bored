<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
<body onUnload="myClose()">

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
                                    <li class="flexbox wc__material-cell" routeUrl="login.html">
                                        <div class="img"><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564997023&di=7b89f986389d6c32a4d8f4566f2bb8aa&imgtype=jpg&er=1&src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F16%2F11%2F08%2F457975867e32809e7493eea1a77287ab.jpg"/></div>
                                        <div class="info flex1">
                                            <h2 class="title">bored</h2>
                                            <p class="desc clamp1">`````欢迎来到bored`````~</p>
                                        </div>
                                        <label class="time">14:42</label>
                                    </li>
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
                                        <div class="row flexbox flex-alignc wc__material-cell" routeUrl="xin">
                                                <img class="uimg" src="static/assets/img/icon__addrFriend-img01.jpg" /><span class="name flex1">新的朋友</span>
                                                 </div>
                                        <div class="row flexbox flex-alignc wc__material-cell">
                                            <img class="uimg" src="static/assets/img/icon__addrFriend-img02.jpg" /><span class="name flex1">群聊</span>
                                        </div>
                                        <div class="row flexbox flex-alignc wc__material-cell">
                                            <img class="uimg" src="static/assets/img/icon__addrFriend-img03.jpg" /><span class="name flex1">标签</span>
                                        </div>
                                    </li>
                                  <li id="li" ></li>
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
                                        <div class="item flexbox flex-alignc wc__material-cell" routeUrl="circle">
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
                                        <div class="item flexbox flex-alignc wc__material-cell" routeUrl="userInfo">
                                            <img class="uimg" id="userImg" src="" />
                                            <span class="txt flex1">
													<em id="userName"></em><i id="userId"></i>
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
            <li class="wc__material-cell"><a href="addUserFriends"><i class="ico i2"></i><span>添加朋友</span></a></li>
            <li class="wc__material-cell"><i class="ico i3"></i><span>帮助与反馈</span></li>
        </ul>
    </div>
</div>

<script type="text/javascript">
    boredmain.init();   //初始化用户数据
    yuang.init();  //初始化sdk
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
