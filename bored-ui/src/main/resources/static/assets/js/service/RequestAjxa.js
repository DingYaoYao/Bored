let bored=function(){
    //请求路径
    let path="http://localhost:9000/api";
    function getJson(url,data,success,error) {
     ajax(url,data,"get","json",success,error)
    }
    function postJson(url,data,success,error) {
        ajax(url,data,"post","json",success,error)
    }
    function ajax(url,data,type,dataType,success,error) {

     $.ajax({
         type : type,           //请求类型
         url:path+url,
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
        path,
        isSuccess,
        isUserError,
        isFusing,
        isError

    }
}();
