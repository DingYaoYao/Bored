let  main=function(){
    //获得用户列表
    function getUserFriends(){
        if(bored.userFriends==null ){
            console.log("从后台get用户好友列表信息！");
            bored.getJson(bored.userFriendsPath,{},function(result){
                if(bored.isSuccess(result)){

                    if(result.data!=null && result.data.length>0){
                       // let userFriends=JSON.stringify(result.data);
                        let userFriends={};  //保存好友信息map
                        for (let i = 0; i < result.data.length; i++) {
                            let user=result.data[i];
                            let userId=user.friendUserId;
                            userFriends[userId]=user;
                        }
                        sessionStorage.setItem(bored.sessionUserFriends,JSON.stringify(userFriends));
                        bored.userFriends=userFriends;
                    }
                  showUserFriends();
                }
            },function (error){
                console.log("获得用户列表异常了==》"+error);
            })
        }else {
            console.log("浏览器中含有用户好友数据")
            showUserFriends();
        }
    }
    //显示好友列表
    function showUserFriends(){
        console.log("用户好友列表展示---")
        let userFriends=bored.userFriends;
        let count=0;
        if(userFriends!=null ){
            for (let userId in userFriends){
                let continal=userFriends.hasOwnProperty(userId)
                if(userFriends.hasOwnProperty(userId)){
                    count++;
                    let   user=userFriends[userId];
                    let userName=user.friend_nicename!=null?user.friend_nicename:user.niceName;
                    let userItem="<li id='F'  class='userInfo' userId='"+userId+"'>" +
                        "                    <h2 class='initial wc__borT'>F</h2>" +
                        "                    <div class='row flexbox flex-alignc wc__material-cell'>\n" +
                        "                    <img class='uimg' src='"+user.picturepath+"'  /><span class='name flex1'>"+userName+"</span>" +
                        "                    </div>" +
                        "                    </li>"
                    $("#my_txl").append(userItem);
                }
            }
            if(count==0){
                $("#my_txl").append("当前用户没有好友!");
            }
        }else{
            $("#my_txl").append("当前用户没有好友!");
        }

    }
function buildUserItemClick(){
        console.log("给好友列表绑定事件！")
    $(".userInfo").on("click",function(){
        let userId=$(this).attr("userId");
        console.log("好友id为--》"+userId);
        if(bored.userFriends.hasOwnProperty(userId)){
             window.location.href="friendInfo/"+userId;
        }else{
            console.log("没能获得用户信息，无法展示好友信息")
        }

    })
}
function initUserInfo(){
        $("#userId").html(bored.userInfo.id);
    $("#userName").html(bored.userInfo.niceName);
    $("#userImg").html(bored.userInfo.picturepath);

}

  return {

        //初始化主页面
        init(){
            if(bored.userInfo==null){ console.log("用户没登陆");return ;}
            getUserFriends();
            buildUserItemClick();
            initUserInfo();
        },
        getUserFriends
  }
}();
