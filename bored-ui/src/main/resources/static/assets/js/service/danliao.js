let picturepath = user.picturepath;   //好友图片路径

function onMsg(msg) {
    let userinfo= bored.userChatInfo[msg.from];
    if (msg.from == user.accid) {
        console.log('收到消息', msg.scene, msg.type, msg);
        let $chatMsgList = $("#J__chatMsgList");
        let msgTpl = [
            "<li class='others'>\
            <a class=avatar' href='haoyouzhuye.html'><img src=" + picturepath + " /></a>\
               <div class='content'>\
                   <div class='msg'>" + msg.text + "</div>\
						</div>\
					</li>"
        ].join("");
        $chatMsgList.append(msgTpl);
    } else {
        if(userinfo==null){
            boredmain.udateUserFriendsData();
            userinfo= bored.userChatInfo[msg.from];
        }
       let userName=userinfo.userName;
        alert(userName + "::给你发来了信息==》" + msg.text);
        console.log("将用户"+userName+"发的信息存储");
    }
    //无论什么消息，都需要保存
    saveData(userinfo.id,msg.text,userinfo.id);
}


$("#bao").on("click", function () {
    //let text = document.getElementById('text').value
    let text = $("#text").html();
    yuang.getNim().sendText({
        scene: 'p2p',
        to: user.accid,
        text: text,
        done: function sendMsgDone(error, msg) {
            if (error == null) {
                let $chatMsgList = $("#J__chatMsgList");
                let msgTpl = [
                    '<li class="me">\
                        <div class="content">\
                            <div class="msg">' + msg.text + '</div>\
						</div>\
						<a class="avatar" href="微聊( ).html"><img src=' + bored.userInfo.picturepath + ' /></a>\
					</li>'
                ].join("");
                $chatMsgList.append(msgTpl);
                saveData(userId,msg.text,bored.userInfo.id)
            }else{
                console.log(error)
                wcPop({ content: "发送消息异常！", time: 2 });
            }
        }
    })



});
//加载自己的聊天记录
function showChatinit(){
   let chatList= bored.userChatList[userId];  //获得聊天列表
    let pic=bored.userInfo.picturepath;     //自己的图片
    let id=bored.userInfo.id;
    let $chatMsgList = $("#J__chatMsgList");
    for (let i = 0; i < chatList.length; i++) {
        let chat  =chatList[i];

        let msgTpl =null;
       if(id==chat.id){
           pic=bored.userInfo.picturepath;     //自己的图片
           msgTpl = [
               '<li class="me">\
                <div class="content">\
                    <div class="msg">' +chat.msg + '</div>\
						</div>\
						<a class="avatar" href="#"><img src=' +pic + ' /></a>\
					</li>'
           ].join("");
       }else{
           pic=bored.userFriends[userId].picturepath;
           let url="/friendInfo/"+chat.id;
           msgTpl = [
               "<li class='others'>\
               <a class=avatar' href="+url+"><img src=" + pic + " /></a>\
               <div class='content'>\
                   <div class='msg'>" + chat.msg + "</div>\
						</div>\
					</li>"
           ].join("");

       }
        $chatMsgList.append(msgTpl);
    }

}



// document.getElementById('bao').addEventListener('click', function () {
// //
// // });
