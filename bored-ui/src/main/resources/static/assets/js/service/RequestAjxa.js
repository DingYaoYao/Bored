let bored=function(){

    //常量
    let sessionUser="BORED";
    let sessionUserFriends="userFriends";
    //请求路径
    let path="http://localhost:9000/api/";
    let loginPath=path+"login/login";
    let registerPath=path+"reg/useradd";
    let userFriendsPath=path+"pal/GetuserPal";   //好友列表路径

    //储存信息
    let tempUserInfo=sessionStorage.getItem(sessionUser);
    let tempUserFriends=sessionStorage.getItem(sessionUserFriends);
    let userFriends=null;          //保存用户好友列表
    let userInfo=null;             //保存用户信息
    let token=null;

    if(tempUserInfo!=null){
        console.log("从浏览器中获得用户信息")
        userInfo=JSON.parse(tempUserInfo);
        token=userInfo.token;
    }
    if(tempUserFriends!=null&& tempUserFriends!='' ){
        console.log("从浏览器中获得用户列表")
        userFriends=JSON.parse(tempUserFriends);
    }

    function getJson(url,data,success,error) {
        ajax(url,data,"get","json",true,success,error)
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


        //请求路径
        loginPath,
        registerPath,
        userFriendsPath,

        //请求ajxa
        getJson,
        postJson,

        //请求判定
        isSuccess,
        isUserError,
        isFusing,
        isError,

        //存储数据
        userFriends,
        userInfo

    }
}();
