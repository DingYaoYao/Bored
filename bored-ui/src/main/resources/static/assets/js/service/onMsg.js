function onMsg(msg) {
    let userinfo= bored.userChatInfo[msg.from];
    if(userinfo==null){
        boredmain.udateUserFriendsData();
        userinfo= bored.userChatInfo[msg.from];
    }
    let userName=userinfo.userName;
    alert(userName + "::给你发来了信息==》" + msg.text);
    console.log("将用户"+userName+"发的信息存储");
    saveData(userinfo.id,msg.text,userinfo.id);
}
