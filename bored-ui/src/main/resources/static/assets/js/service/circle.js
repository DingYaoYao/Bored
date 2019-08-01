let circle = function () {
    let data=null;   //保存好友朋友圈列表信息
    //初始化信息
    function initInfo() {
        $("#userName").html(bored.userInfo.nicename);
        $("#backImg").attr("src", bored.userInfo.backImg);
        $("#userImg").attr("src", bored.userInfo.picturepath);
    }
    //从后台获得信息
    function getDate() {

        bored.getJson(bored.myFriendFriends, {}, function (result) {
              if(bored.isSuccess(result)){
                  console.log(result.data);
                  data=result.data;
                  showInfo();
              }else{
                  wcPop({ content: '获得数据失败！', time: 2 });
              }
        }, function (error) {
            wcPop({ content: '获得数据异常！', time: 2 });
        })
    }

        /**
         * 计算时间戳与当前时间的差值
         * @param start_time 开始时间戳
         */
        function calculateDiffTime(start_time) {
            if(!parseInt(start_time)) return "-";
            let endTime = Math.round(new Date() / 1000);

            let timeDiff = endTime - start_time
            let day = parseInt(timeDiff / 86400);
            let hour = parseInt((timeDiff % 86400) / 3600);
            let minute = parseInt((timeDiff % 3600) / 60);

            // day = day>0?(day+'天'):'';
            // hour = hour>0?(hour+"时"):'';
            // minute = minute>0?(minute+"分"):'';
            console.log(day+":"+hour+":"+minute)
day = day?(day+'天'):'';
            hour = hour?(hour+"时"):'';
            minute = minute?(minute+"分"):'';
            console.log(day+":"+hour+":"+minute)
            return day + hour + minute;
        }
   //显示数据
    function showInfo(){
            if(data==null || data.length==0){
            $("#J__cmtList").attr("style", "background:url('/static/assets/img/empty.PNG') no-repeat;width:100%;height:1000px;");
            return ;
        }
        for (let i = 0; i <data.length ; i++) {
            let friend=data[i];   //获得
            let imagepath=friend.imagepath.split(",,,");  //朋友圈图片路径
            let userName=friend.friend_nicename!=null?friend.friend_nicename:friend.niceName;
            let context=friend.context;
            let picturepath=friend.picturepath;
            let date=friend.createtime;

            let imgs="<p>";
            for (let j = 0; j < imagepath.length; j++) {
                let path=imagepath[j];
                imgs+="<img class='list-img' src="+path+"/>";
            }
            imgs+=" </p>";
            let item="  <li>\n" +
                " <div class=\"wrap-avt fl\"><img src="+picturepath+" /></div>\n" +
                "  <div class=\"wrap-cmt\">\n" +
                "  <div class=\"cmt-hd\">\n" +
                " <h2 class=\"u-name\">"+userName+"</h2>\n" +
                "  <div class=\"post__cnt clearfix\">\n" +
                "  <p>"+context+"</p>\n" +imgs+
                "   </div>\n" +
                " <div class=\"reply__box clearfix\">\n" +
                "  <label class=\"time fl c--999\">"+calculateDiffTime(new Date(date).getTime())+"</label>\n" +
                "  <a class=\"btn-reply fr\" href=\"javascript:;\"></a>\n" +
                "  <!-- 评论弹窗 -->\n" +
                "   <div class=\"wc__cmtbox\">\n" +
                " <a class='like' href=\"javascript:;\" id=\"J__btnLike\"><i></i>赞</a>\n" +
                "    <a class=\"cmt\" href=\"javascript:;\" id=\"J__btnCmt\"><i></i>评论</a>\n" +
                "</div>\n" +
                " </div>\n" +
                " </div>\n" +
                " </div>\n" +
                " </li>";

            $("#J__cmtList").append(item);
        }
        build();

    }

      function build(){
          // 显示点赞、评论框
          $("#J__cmtList li").on("click", ".btn-reply", function(){
              $(this).siblings(".wc__cmtbox").fadeIn(300);
              $(this).parents("li").siblings().find(".wc__cmtbox").hide();
          });
          // 隐藏点赞、评论框
          $(window).on("scroll", function () {
              $(".wc__cmtbox").hide();
          });

          // 评论
          $("#J__cmtList li").on("click", "#J__btnCmt", function(){
              alert(9)
          });
      }
    return {
        init() {
            initInfo();
            getDate();
        }
    }

}();
