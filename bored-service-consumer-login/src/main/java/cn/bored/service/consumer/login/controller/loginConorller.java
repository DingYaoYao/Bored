package cn.bored.service.consumer.login.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import cn.bored.service.consumer.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class loginConorller extends AbstractBaseController<User> {

    @Autowired
    private LoginService loginService;

    public AbstractBaseResult loginl(Long id, String password) {
        User login1 = loginService.loginl(id,password);
        if(login1 == null){
            return error("账号密码错误");
        }else if(login1.getNicename().equals("")){
            return error("该账户已登录");
        }
        return success("",login1);
    }


}
