let bored=function(){

    //常量
    let sessionUser="BORED";
    let sessionUserFriends="userFriends";
    let sessionUserChatInfo="userChatInfo";
    let sessionUserChatList="UserChatList";
    //请求路径
    let path="http://localhost:9000/api/";
    let loginPath=path+"login/login";
    let registerPath=path+"reg/useradd";
    let userFriendsPath=path+"pal/GetuserPal";   //好友列表路径
    let getUserById=path+"user/getuser/";         //根据id获得用户，路径参数
    let applyAdd=path+"apply/add";               //添加好友申请
    let applyDecided=path+"apply/decided";        //获得好友申请列表
    let applyConsent=path+"apply/consent/";       //同意好友申请，路径参数
    let myFriendFriends=path+"friend/myfriendFriends";   //获得全部好友朋友圈

    //储存信息
    let tempUserInfo=sessionStorage.getItem(sessionUser);
    let tempUserFriends=sessionStorage.getItem(sessionUserFriends);
    let tempUserChatInfo=sessionStorage.getItem(sessionUserChatInfo);
    let tempUserChatList=sessionStorage.getItem(sessionUserChatList);
    let userFriends=null;          //保存用户好友列表map {好友id：{好友信息}，。。。。。}
    let userInfo=null;             //保存用户信息{attr:value,...}
    let token=null;                //保存用户标识{value}
    let userChatInfo=null;         //保存用户聊天基本信息map{云信id:{好友简单信息}，。。。。}
    let userChatList=null;         //保存用户聊天信息{用户id:{list},,,,.....}

    if(tempUserInfo!=null){
        console.log("从浏览器中获得用户信息");
        userInfo=JSON.parse(tempUserInfo);
        token=userInfo.token;
    }
    if(tempUserFriends!=null&& tempUserFriends!='' ){
        console.log("从浏览器中获得用户列表");
        userFriends=JSON.parse(tempUserFriends);
    }
    if(tempUserChatInfo!=null){
        console.log("从浏览器中获得用户聊天基本信息");
        userChatInfo=JSON.parse(tempUserChatInfo);
    }
    if(tempUserChatList!=null){
        console.log("从浏览器中获得用户聊天列表信息");
        userChatList=JSON.parse(tempUserChatList);
    }

    function getJson(url,data,success,error) {
        ajax(url,data,"get","json",true,success,error)
    }
    function getJsonAsync(url,data,success,error) {
        ajax(url,data,"get","json",false,success,error)
    }
    function postJson(url,data,success,error) {
        ajax(url,data,"post","json",true,success,error)
    }
    function ajax(url,data,type,dataType,async,success,error) {
        $.ajax({
            async:async,
            headers:{'bored':token},
            type : type,           //请求类型
            url:url,
            dataType : dataType,   //ajax接口（请求url）返回的数据类型
            data:data,
            success:success,
            error:error
        })
    }

    //判断是否执行成功
    function isSuccess(result){
       let  code=result.code;
       if(code!=null && code==200){
          return true;
       }
       return false;
    }
    //判断是否为用户没权限访问
    function  isUserError(result) {
        let  code=result.code;
        if(code!=null && code==201){
            return true;
        }
        return false;
    }
    //判断服务熔断
    function isFusing(result){
        let  code=result.code;
        if(code!=null && code==202){
            return true;
        }
        return false;
    }
    //判断操作失败
    function isError(result){
        let  code=result.code;
        if(code!=null && code==401){
            return true;
        }
        return false;
    }

    return {
        //常量
        sessionUser,
        sessionUserFriends,
        sessionUserChatInfo,
        sessionUserChatList,
        //请求路径
        loginPath,
        registerPath,
        userFriendsPath,
        getUserById,
        applyAdd,
        applyDecided,
        applyConsent,
        myFriendFriends,

        //请求ajxa
        getJson,
        postJson,
        getJsonAsync,
        //请求判定
        isSuccess,
        isUserError,
        isFusing,
        isError,

        //存储数据
        userFriends,
        userInfo,
        userChatInfo,
        userChatList
    }
}();
