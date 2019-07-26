let  flag=true;
// 登录验证
$("#J__btnLogin").on("click", function(){
if(flag){
    let userNum = $("#userNum").val().trim();
    let password = $("#password").val().trim();

    let regularNUm=/^\d{9}$/;
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

        $.post(bored.loginPath,{"id":userNum,"password":password},function(result){
            if(bored.isSuccess(result)){
                console.log(result.data);

                //保存用户信息
                sessionStorage.setItem(bored.sessionUser,JSON.stringify(result.data));

                window.location.href="main";


               // window.location.href="main";
            }else if(bored.isError(result)){
                console.log(result.message);
            }else {
                console.log("网络异常！，请重试！");

            }
            flag=true;
        });
    }

}

});
