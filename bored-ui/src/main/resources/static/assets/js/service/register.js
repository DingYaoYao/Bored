let flag=true;
// 注册验证
$("#register").on("click", function(){
if(flag){
    let pwd = $("#password").val().trim();
    let nickname = $("#nickname").val().trim();
    let phone = $("#phone").val().trim();

    let regularPwd=/^[A-Za-z0-9]{1,6}$/;
    let regularNickname=/^[A-Za-z0-9]{1,15}$/;
    let regularPhone=/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;

    if(phone==''){
        wcPop({ content: '手机号不能为空！', time: 2 });
    }else if( nickname== ''){
        wcPop({ content: '昵称不能为空！', time: 2 });
    }else if (pwd=='') {
        wcPop({ content: '密码不能为空！', time: 2 });
    }else if(!regularPhone.test(phone)){
        wcPop({ content: '手机号格式不正确！', time: 2 });
    } else if(!regularNickname.test(nickname)){
        wcPop({ content: '昵称不能超过15位！', time: 2 });
    }else if(!regularPwd.test(pwd)){
        wcPop({ content: '密码格式不正确！', time: 2 });
    }else{
        flag=false;
        $("#register").css("disable","true")

        $.post(bored.registerPath,{"nicename":nickname,"password":pwd,"phone":phone},function(result){
            if(bored.isSuccess(result)){
                console.log("获得注册id==>"+result.data)
                $("#userNum").val(result.data);
                $("#accId").css("display","block");
            }else if(bored.isError(result)){
                console.log(result.message);
            }else {
                console.log("网络异常！，请重试！");

            }
            flag=true;

        });
    }
}

});// $("#regist").on
