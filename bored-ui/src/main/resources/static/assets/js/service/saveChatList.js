window.onbeforeunload=function (){
    console.log("保存用户聊天信息--------");
    sessionStorage.setItem(bored.sessionUserChatList,JSON.stringify(bored.userChatList))
    console.log("我要跳转界面了--------");
}
window.onunload=function(){
    console.log("我要跳转界面了--------");
}
function myClose(){
    console.log("我要跳转界面了--------");
}

function saveData(id,msg,nid){
    let chatArray=bored.userChatList[id];  //得到信息列表
    if(chatArray!=null){
        let size=chatArray.length;
        console.log("信息长度为："+size);
        chatArray[size]={"id":nid,"msg":msg};
        console.log("js对象中数据==》"+bored.userChatList[id]);
    }else{
        console.log("当前聊天记录没有和用户的聊天记录添加一个");
        //判断用户是否存在
        //暂时这个还不行，需要重新请求数据获得用户好友列表才行
        if(bored.userFriends[id]==null){
            boredmain.udateUserFriendsData();
        }
        chatArray=new Array();
        chatArray[chatArray.length]={"id":nid,"msg":msg};
        bored.userChatList[id]=chatArray;
        }
}
