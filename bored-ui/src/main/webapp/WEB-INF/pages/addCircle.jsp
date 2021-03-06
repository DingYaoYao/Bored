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
    <title>发表动态</title>
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
       <style>
        .pic img {
            width: 100px;
            height: 100px;
            margin: 1px;
        }
        .uploadImgBtn {
            width: 100px;
            height: 100px;
            cursor: pointer;
            position: relative;
            background: url("static/assets/img/wchat/icon__choose-zp.png") no-repeat;
            -webkit-background-size: cover;
            background-size: cover;
        }
        .uploadImgBtn .uploadImg {
            position: absolute;
            right: 0;
            top:0;
            width: 100%;
            height: 100%;
            opacity: 0;
            cursor: pointer;
        }
        .pic{
            border: grey 1px solid;
            width: 99%;
            height: auto;
            position: absolute;
            bottom: 5rem;
            margin: 1px;
        }
        .my_textarea{
            border: 5px #f8f8f8 solid;
            width:100%;
            height:3rem;
            padding: 5px;
        }
        .span{
            color: #ffd100;
        }
    </style>
</head>
<body>
<!-- <>微聊主容器 -->
<div class="wechat__panel clearfix">
    <div class="wc__chat-wrapper flexbox flex__direction-column">
        <!-- //顶部 -->
        <div class="wc__headerBar fixed">
            <div class="inner flexbox">
                <a class="back splitline" href="javascript:;" onClick="history.back(-1);"></a>
                <h2 class="barTit flex1">发布动态</h2>
            </div>
        </div>
        <div>
            <div>
                <form action="faBuDongTai" id="my_form" name="form" method="post" enctype="multipart/form-data">
                    <textarea class="my_textarea" name="content" placeholder="说点什么吧"></textarea>
                    <div class="uploadImgBtn" id="uploadImgBtn">
                        <p>
                            <input class="uploadImg" type="file" name="file" multiple id="file" accept="image/gif, image/jpeg, image/png"><br/>
                            <br/>
                            <br/>
                            <span class="span">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择图片</span>
                        </p>
                    </div>
                </form>
            </div>
        </div>
        <div class="pic" id="my_pic"></div>
        <button class="btn-submit J__wchatSubmit" id="my_bot">发布</button>
    </div>
</div>
</body>
<script type="text/javascript">
    /** __公共函数 */
    //为外面的盒子绑定一个点击事件
    $("#uploadImgBtn").click(function(){
        /*
        1、先获取input标签
        2、给input标签绑定change事件
        3、把图片回显
         */
//            1、先回去input标签
        var $input = $("#file");
        console.log($input)
//            2、给input标签绑定change事件
        $input.on("change" , function(){
            console.log(this)
            //补充说明：因为我们给input标签设置multiple属性，因此一次可以上传多个文件
            //获取选择图片的个数
            var files = this.files;
            var length = files.length;
            console.log("选择了"+length+"张图片");
            //3、回显
            $.each(files,function(key,value){
                //每次都只会遍历一个图片数据
                var div = document.getElementById("my_pic"),
                    img = document.createElement("img");
                var fr = new FileReader();
                fr.onload = function(){
                    img.src=this.result;
                    div.appendChild(img);
                }
                fr.readAsDataURL(value);
            })

        })

        //4、我们把当前input标签的id属性remove
        $input.removeAttr("id");
        //我们做个标记，再class中再添加一个类名就叫test
        var newInput = '<input class="uploadImg test" type="file" name="file" multiple id="file">';
        $(this).append($(newInput));

    })
    $("#my_bot").on("click",function () {
        $("#my_form").submit();

    })

</script>
</html>

