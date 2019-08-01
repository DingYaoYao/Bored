let newPriends = function () {
    let newPriends = null;  //保存好友待申请的列表
    let userId=null;        //标记要统一添加的好友id
    function getData() {
        bored.getJson(bored.applyDecided, {}, function (result) {
            console.log(result.data);
            if (bored.isSuccess(result)) {
                newPriends = result.data;
                showInfo();
            }
            empty();
        }, function (error) {
            wcPop({ content: "获得用带申请列表失败!", time: 2 });

            console.log("获得用带申请列表失败！" + error);
            empty();
        })
    }
function empty(){
    if(newPriends==null || newPriends.length<=0){
        $("#user_info").attr("style", "background:url('/static/assets/img/empty.PNG') no-repeat;width:100%;height:100%;");
    }
}
    //展示数据
    function showInfo() {
        console.log("展示用户好友请求数据");
        for (let i = 0; i < newPriends.length; i++) {
            let user = newPriends[i];
            let picturepath = user.picturepath;
            let fromUser = user.fromUser;
            let toUser = user.toUser;
            let message = user.message;
            let nicename = user.nicename;

            let item = "  <li>\n" +
                "  <div class='item flexbox flex-alignc wc__material-cell' " +
                "toId="+toUser+" "+
                "fromId="+fromUser+">" +
                "     <img class='uimg' src=" + picturepath + " />\n" +
                "      <label class=\"lbl flex1\">\n" +
                "      <em >" + nicename + "</em><i >" + message + "</i>\n" +
                "     </label>" ;
            if(fromUser==bored.userInfo.id){
                item=item+"<span>等待验证</span>";
            }else{
                item=item+"<button class='consent' >同意</button>";
            }
            item=item+'</div> </li>';
            $("#newPriends").append(item);
        }

        build();
    }
    //获得要操作的用户id
    function getId(obj){
        let toId= $(obj).attr("toId");
        let fromId= $(obj).attr("fromId");
        if(toId==bored.userInfo.id){
            userId=fromId;
        }else{
            userId=toId;
        }
    }
    //添加同意事件
    function build(){
        $(".consent").on("click",function(){
            //获得谁给我发的用户id
            let label=$(this).prev();
            userId= $(this).parents("div").attr("fromId");
            console.log("好友请求添加id===》"+userId);
            console.log(bored.applyConsent+userId);
              bored.getJson(bored.applyConsent+userId,{},function(result){
                  if(bored.isSuccess(result)){
                      boredmain.udateUserFriendsData();
                      wcPop({ content: '添加申请成功！', time: 2 ,icon:"success"});
                     label.next().remove();
                     label.parents("div").append("<span>已添加</span>");
                     let user=bored.userFriends[userId];
                     yuang.sendText("我们已经是好友了，一起聊天吧！",user.accid,user.friendUserId)
                  }else{
                      console.log("error"+result.message)
                      wcPop({ content: '申请失败，请重试！', time: 2 });
                  }
              },function(){
                  wcPop({ content: '申请异常，请重试！', time: 2 });
              })
        });
    }

    return {
        init() {
            getData();
        }
    }
}();


