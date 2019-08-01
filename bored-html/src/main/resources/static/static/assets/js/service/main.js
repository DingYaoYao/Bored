let boredmain = function (ee) {
    let isReset=false;   //标记是否已经加载用户列表了
    let chatCount=0;          //
    //获得用户列表，并显示
    function getUserFriends() {
        if (bored.userFriends == null) {
          //加载数据，并显示
            isReset=false;
            getdata(true);
        } else {
            //显示数据
            console.log("浏览器中含有用户好友数据");
            showUserFriends();
        }
    }

    //更新用户列表数据
    function udateUserFriendsData(){
        isReset=false;
        //加载数据不显示
        getdata(false);
        isReset=true;
    }

    /**
     * 获得好友列表
     * @param isShow  是否显示数据，因为只有主页才显示，其他界面可能只是需要新数据
     */
    function getdata(isShow) {
        if(!isReset){
            isReset=true;    //标记为已加载数据
            console.log("从后台get用户好友列表信息！");
            bored.getJsonAsync(bored.userFriendsPath, {}, function (result) {
                if (bored.isSuccess(result)) {
                    let flag = bored.userChatList == null;  //标记是否重新更新用户聊天信息
                    console.log("标记是否重新更新用户聊天信息"+!flag);
                    if (result.data != null && result.data.length > 0) {
                        // let userFriends=JSON.stringify(result.data);
                        let userFriends = {};    //保存好友信息map
                        let userChatInfo = {};   //用户聊天基本信息
                        let userChatList = {};   //聊天信息
                        for (let i = 0; i < result.data.length; i++) {
                            let user = result.data[i];
                            let userId = user.friendUserId;
                            userFriends[userId] = user;
                            userChatInfo[user.accid] = {
                                "id": userId,
                                // "picturepath": user.picturepath,
                                "userName": checkUserName(user)
                            }
                            if (flag) {
                                userChatList[userId] = new Array();
                            }
                        }
                        if (flag) {
                            sessionStorage.setItem(bored.sessionUserChatList, JSON.stringify(userChatList))
                            bored.userChatList = userChatList;
                        }
                        sessionStorage.setItem(bored.sessionUserChatInfo, JSON.stringify(userChatInfo))
                        sessionStorage.setItem(bored.sessionUserFriends, JSON.stringify(userFriends));
                        bored.userFriends = userFriends;
                        bored.userChatInfo = userChatInfo;
                    }
                    if(isShow)
                        showUserFriends();
                } else {
                    wcPop({content: result.message, time: 2});
                    console.log("" + result.message)
                }
            }, function (error) {
                wcPop({content: "获得用户列表异常了==》", time: 2});
                console.log("获得用户列表异常了==》" + error);
            });
        }
    }
    function checkUserName(user) {
        return user.friendNicename != null && user.friendNicename.trim()!='' ? user.friendNicename : user.niceName;
    }

    //显示好友列表
    function showUserFriends() {
        console.log("用户好友列表展示---")
        let userFriends = bored.userFriends;
        let count = 0;
        if (userFriends != null) {
            for (let userId in userFriends) {
                let continal = userFriends.hasOwnProperty(userId)
                if (continal) {
                    count++;
                    let user = userFriends[userId];
                    let userName = checkUserName(user);

                    let userItem = "<li id='F'  class='userInfo'   routeUrl="+"friendInfo/"+userId+">" +
                        "                    <h2 class='initial wc__borT'>F</h2>" +
                        "                    <div class='row flexbox flex-alignc wc__material-cell'>\n" +
                        "                    <img class='uimg' src='" + user.picturepath + "'  /><span class='name flex1'>" + userName + "</span>" +
                        "                    </div>" +
                        "                    </li>"
                    $("#my_txl").append(userItem);
                }
            }
            if (count == 0) {
                empty();
                //$("#my_txl").append("还没有好友？？");
            }
        } else {
            empty();
            // $("#my_txl").append("还没有好友？？");

        }
       // buildUserItemClick();
    }

    function empty() {
        $("#li").attr("style", "background:url('/static/assets/img/empty.PNG') no-repeat;width:100%;height:1000px;");
    }

    // function buildUserItemClick() {
    //     console.log("给好友列表绑定事件！")
    //     $(".userInfo").on("click", function () {
    //         let userId = $(this).attr("userId");
    //         console.log("好友id为--》" + userId);
    //         if (bored.userFriends.hasOwnProperty(userId)) {
    //             window.location.href = "friendInfo/" + userId;
    //         } else {
    //             console.log("没能获得用户信息，无法展示好友信息")
    //         }
    //
    //     })
    // }

    function initUserInfo() {

        $("#userId").html(bored.userInfo.id);

        $("#userName").html(bored.userInfo.nicename);
        $("#userImg").attr("src", bored.userInfo.picturepath);

    }
    function showUserChatInfoList(){
        let chatList=bored.userChatList;
        for(let userId in chatList){
            let chats=chatList[userId];  //获得每个用户的聊天列表
            if(chats!=null && chats.length>0){

                let user=bored.userFriends[userId];
                let chat=chats[chats.length-1];  //获得最后一条记录
                let item='<li class="flexbox wc__material-cell userInfo " routeUrl='+"danliao/" + userId+'>\n' +
                    '<div class="img"><img src='+user.picturepath+' /></div>\n' +
                    '<div class="info flex1">\n' +
                    '<h2 class="title">'+checkUserName(user)+'</h2>\n' +
                    '<p class="desc clamp1">'+chat.msg+'</p>\n' +
                    '</div>\n' +
                    '<label class="time">14:42</label>\n' +
                    '</li>';
                $("#my_ul").append(item);
            }

        }
        console.log("展示用户聊天数据");
   //  buildUserItemClick();
    }

    return {
        //初始化主页面
        init() {
            if (bored.userInfo == null) {
                console.log("用户没登陆");
                return;
            }
            //1加载后台聊天记录

            //2加载用户数据数据不显示数据,如果数据存在不加载
            if (bored.userFriends == null) {
                getdata(false);
            }
            //3显示用户聊天信息
            showUserChatInfoList();
            //4显示好友列表
            getUserFriends();
            //5.初始化用户信息
            initUserInfo();
        },
        udateUserFriendsData,

    }
}();
