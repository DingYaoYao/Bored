let searchId=null;    //好友id
let flag=true;        //标记用户是否可以向后台发送搜索请求
let userNum =null ;   //输入框好友id
let addFlag=true;      //标记用户是否可以向后台发送搜索请求
// 请求用户搜索好友信息
function searchUser(){
    userNum = $("#userNum").val().trim();
    if(userNum == '') {
        wcPop({content: '用户名不能为空！', time: 1});

    }else if(searchId!=null && userNum==searchId){
        console.log("搜索结果一样！");
        return ;
    } else{
        if(flag){
            flag=false;
            console.log("向后台发送异步请求获得用户"+bored.getUserById);
            bored.getJson(bored.getUserById+userNum,{},function(result){
                if(bored.isSuccess(result))
                    showUserInfo(result.data);
                else if(bored.isFusing(result) ||(bored.isError(result)&& result.data==null )){
                    showUserInfo(null);
                    searchId=null;
                }else if(bored.isUserError(result)){
                    wcPop({content: '请登录！！', time: 1});
                }else
                    showUserInfo(null);
            },function(error){
                wcPop({ content: '搜索好友异常了，请重试！', time: 2 });
                console.log("搜索好友异常了！");
                showUserInfo(null);
                searchId=null
            })
        }else{
            console.log("当前用户不能向后台发送请求！");
            /*设置几秒后可以操作*/
            setTimeout(function(){
                console.log("手动设置用户可以请求")
                /*手动设置用户可以请求*/
                flag=true;
            },3000);
        }
    }
}
//展示搜索用户信息
function showUserInfo(result){
    //显示没有用户
    if(result==null){
        $("#not_user").css("display","block");
        $("#user_info").css("display","none");
    }else{
        $("#remark").val(result.nicename);
        $("#common").val(" 我是 "+bored.userInfo.nicename);
        $("#user_info").css("display","block");
        $("#not_user").css("display","none");
        $("#searchId").html("账号："+result.id);
        $("#searchName").html(result.nicename);
        $("#searchImg").attr("src",result.picturepath);
        $("#searchAddress").html(result.addressId);
    }
    searchId=userNum;
    flag=true;
}
//添加好友申请
function addUserFriend() {
    if(bored.userInfo.id==searchId){
        wcPop({content: '不能添加自己为好友哦！！', time: 1});
        return ;
    }
    if(addFlag){
        addFlag=false;
        let message=$("#common").val().trim();  //用户请求带的消息
        let remark=$("#remark").val().trim();    //用户备注
        bored.postJson(bored.applyAdd,{"remark":remark,"message":message,"fromUser":bored.userInfo.id,"toUser":searchId},
            function(result){
                if(bored.isSuccess(result)){
                    wcPop({ content: '添加申请成功！', time: 2 ,icon:"success"});
                    console.log("添加申请成功");
                }else{
                    wcPop({ content: '申请失败，请重试！', time: 2 });
                    console.log("smessg"+result.message+result.code);
                }
                addFlag=true;
            },function(error){
                console.log("申请好友异常了"+error)
                wcPop({ content: '申请好友异常了，请重试！', time: 2 });
                addFlag=true;
            })
    }else{
        console.log("用户不能进行添加好友请求操作！")
    }
}
