let  flag=true;
// 登录验证
$("#J__btnLogin").on("click", function(){
if(flag){
    let userNum = $("#userNum").val().trim();
    let password = $("#password").val().trim();

    let regularNUm=/^\d{6,9}$/;
    let regularPwd=/^[A-Za-z0-9]{1,6}$/;

    if(userNum == ''){
        wcPop({content: '账户不能为空！', time: 2});
    }else if(password == ''){
        wcPop({ content: '密码不能为空！', time: 2 });
    }else if(!regularNUm.test(userNum)){
        wcPop({content: '请输入正确的账号！', time: 2});
    }else if(!regularPwd.test(password)) {
        wcPop({content: '请输入正确的密码格式！', time: 2});
    }
    else{
        flag=false;
      bored.postJson(bored.loginPath,{"id":userNum,"password":password},
          function(result){
            if(bored.isSuccess(result)){
                sessionStorage.clear();
                console.log(result.data);
                //保存用户信息
                sessionStorage.setItem(bored.sessionUser,JSON.stringify(result.data));
                window.location.href="main";
               // window.location.href="main";
            }else if(bored.isError(result)){
                wcPop({ content: result.message, time: 2 });

                console.log(result.message);
            }else {
                wcPop({ content: "网络异常！，请重试！", time: 2 });

                console.log("网络异常！，请重试！");

            }
            flag=true;
        },function(error){
          console.log("登陆请求异常");
              flag=true;
          });
    }

}

});
