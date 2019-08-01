let yuang=function(){
    //设置SDK
    let nim=23453;
    function onRoamingMsgs(obj) {
        console.log('收到漫游消息', obj);
    }

    function onOfflineMsgs(obj) {
        console.log('收到离线消息', obj);
        let length=obj.msgs.length;
        for (let i = 0; i < length; i++) {
            let msg=obj.msgs[i];
            let user= bored.userChatInfo[msg.from];
            if(user==null){
                boredmain.udateUserFriendsData();
            }
            let id= bored.userChatInfo[msg.from].id;
            saveData(id,msg.text,id);
        }
    }

    function connSDK () {
        console.log("成功");
        // alert(bored.userInfo.accid);
        // alert(bored.userInfo.token);
          nim = SDK.NIM.getInstance({
            appKey: "53d4384297427bff1eb901be42f2e18a",
            account: bored.userInfo.accid,
            token: bored.userInfo.token,
            onconnect: function () {
              //  alert('SDK 连接成功');
                console.log("连接成功")
            },
            ondisconnect: function (obj) {
                console.log('SDK 连接断开', obj)
            },
            onerror: function (error) {
                console.log('SDK 连接失败', error)
            },
              onroamingmsgs: onRoamingMsgs,
              onofflinemsgs: onOfflineMsgs,
              onmsg: onMsg
        });
        console.log(nim+"++++++++++++++++++++++");
         // nim.sendText(function(){});
    }
    //发送信息，将信息发送给指定人
    function sendText(text,userAccid,userId){
        nim.sendText({
            scene: 'p2p',
            to: userAccid,
            text: text,
            done: function sendMsgDone(error, msg) {
                if(error==null){
                    console.log("发送成功！");
                    saveData(userId,text,bored.userInfo.id)
                }
            }
        });
    }
    return {
        init(){
            connSDK();
        },
        getNim(){
            return  nim;
        },
        sendText

    }
}();
