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
    <script type='text/javascript' src='static/assets/js/huanxin/webim.config.js'></script>
    <script type='text/javascript' src='static/assets/js/huanxin/strophe-1.2.8.js'></script>
    <script type='text/javascript' src='static/assets/js/huanxin/websdk-1.4.13.js'></script>

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
            </div>
        </div>

        <!-- //weiyouquan -->
        <div class="wc__friendZone">
            <div class="head">
               <c:if test="${user.backimg!=null}">
                   <img class="cover J__covers" src="static/assets/img/placeholder/${user.backimg}" />
               </c:if>
                <c:if test="${user.backimg==null}">
                    <img style="width:100%;height:100%;" src="static/assets/img/uimg/${user.headPortrait}" />
                </c:if>
                <p class="uname">${user.nickname}</p>
                <a class="my_img" href="toFaBiaoDongTai"><img src="static/assets/img/placeholder/fabu.png"/> </a>
                <a class="avator" href="#"><img src="static/assets/img/uimg/${user.headPortrait}" /></a>
            </div>
            <c:set  var="userNum" scope="request" value="${user.userNum}"></c:set>
            <!-- //列表区 -->
            <div class="cont">
                <div class="inner">
                    <ul class="wc__cmtlist clearfix" id="J__cmtList">
                        <c:forEach var="say" items="${sayListForUser}">
                            <c:set var="flag" value="1"/>
                                <c:forEach var="userFriend" items="${userFriendList}">
                                    <c:if test="${flag==1}">
                                    <c:if test="${say.userNum==userFriend.userNum}">
                                        <c:set var="flag" value="2"/>
                                        <li>
                                            <div class="wrap-avt fl"><img src="static/assets/img/uimg/${userFriend.headPortrait}" /></div>
                                            <div class="wrap-cmt">
                                                <div class="cmt-hd">
                                                    <h2 class="u-name">${userFriend.remark!=null?userFriend.remark:userFriend.nickname}</h2>
                                                    <div class="post__cnt clearfix">
                                                        <p></p>
                                                        <p>
                                                            <c:if test="${say.image1!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image1}" />
                                                            </c:if>
                                                            <c:if test="${say.image2!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image2}" />
                                                            </c:if>
                                                            <c:if test="${say.image3!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image3}" />
                                                            </c:if>
                                                            <c:if test="${say.image4!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image4}" />
                                                            </c:if>
                                                            <c:if test="${say.image5!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image5}" />
                                                            </c:if>
                                                            <c:if test="${say.image6!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image6}" />
                                                            </c:if>
                                                            <c:if test="${say.image7!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image7}" />
                                                            </c:if>
                                                            <c:if test="${say.image8!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image8}" />
                                                            </c:if>
                                                            <c:if test="${say.image9!=null}">
                                                                <img class="list-img" src="static/assets/img/placeholder/${say.image9}" />
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                    <div class="reply__box clearfix">
                                                        <label class="time fl c--999">${say.sayContent}</label>
                                                        <a class="btn-reply fr" href="javascript:;"></a>
                                                        <!-- 评论弹窗 -->
                                                        <div class="wc__cmtbox">
                                                            <a class="like"  onclick="onLike(${say.sayId});" id="J__btnLike"><i></i>赞</a>
                                                            <a class="cmt" href="javascript:;" id="J__btnCmt"><i></i>评论</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="arr"></div>
                                                <div class="cmt-bd">
                                                    <div class="like" id="${say.sayId}">
                                                            <c:forEach var="praise" items="${praiseMap.keySet()}">
                                                                <c:if test="${praise==say.sayId}">
                                                                    <c:set var ="istrue" value="1"/>
                                                                    <c:set var ="yang" value="1"/>
                                                                    <c:if test="${yang==1}">
                                                                        <c:forEach var="p" items="${praiseMap.get(praise)}">
                                                                            <c:if test="${istrue!=1}">
                                                                                <span>,</span><span>${p.userNum}</span>
                                                                            </c:if>

                                                                            <c:forEach var="praiseUser" items="${praiseUserList}">
                                                                                ${praiseUser.userNum}--${p.userNum}
                                                                                <c:if test="${praiseUser.userNum==p.userNum}">
                                                                                    <span>${praiseUser.nickname}</span>
                                                                                    ${praiseUser.userNum}-if-${p.userNum}
                                                                                    <c:set var ="yang" value="2"/>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                            <c:set var ="istrue" value="2"/>
                                                                        </c:forEach>
                                                                    </c:if>

                                                                </c:if>
                                                            </c:forEach>

                                                    </div>
                                                    <div class="reply-list">
                                                        <c:forEach var="comment" items="${commentMap.keySet()}">
                                                            <c:if test="${comment==say.sayId}">
                                                                <c:forEach var="p" items="${commentMap.get(comment)}">
                                                                    <c:set var="isone" value="1"></c:set>
                                                                        <c:forEach var="commentUser" items="${commentUserList}">
                                                                            <c:if test="${isone==1}">
                                                                            <c:if test="${commentUser.userNum==p.userNum}">
                                                                                <c:set var="isone" value="2"></c:set>
                                                                                <p><span>${commentUser.nickname}:</span>${p.content}</p>
                                                                            </c:if>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                </c:forEach>
                                                            </c:if>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:if>
                                    </c:if>
                                </c:forEach>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function onLike(sayId) {
        var userNum='<%= request.getAttribute("userNum")%>';
        alert(sayId);
        $.ajax({
            url: "like",
            data: {"sayId":sayId,"userNum":userNum},
            type:"post",
            success: function (data) {
               if(data=="true"){
                   var flag= $("#"+sayId).val();
                   if (flag==""||flag==null){
                       alert("拼接");
                       $("#"+sayId).appendChild("<span>"+userNum+"</span>");
                   }else{
                       $("#"+sayId).appendChild("<span>,</span>");
                       $("#"+sayId).appendChild("<span>"+userNum+"</span>");
                   }
               }else{
               }
            }
        });
    }
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

        // 显示点赞、评论框
        $("#J__cmtList li").on("click", ".btn-reply", function(){
            $(this).siblings(".wc__cmtbox").fadeIn(300);
            $(this).parents("li").siblings().find(".wc__cmtbox").hide();
        });
        // 隐藏点赞、评论框
        $(window).on("scroll", function () {
            $(".wc__cmtbox").hide();
        });
        //点赞

       $("#J__btnLike").on("click",function () {

        });
        // 评论
        $("#J__cmtList li").on("click", "#J__btnCmt", function(){
            alert("抱歉，该用户未开启评论权限")
        });
    });
</script>

</body>
</html>

