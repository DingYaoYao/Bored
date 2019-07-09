package cn.bored.service.consumer.login.controller;

import cn.bored.api.redis.RedisService;
import cn.bored.common.utils.JsonUtils;
import cn.bored.service.api.login.LoginService;
import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/login")
public class loginConorller extends AbstractBaseController<User> {

    @Data
    public static class  test implements Serializable {
        private static final long serialVersionUID = -697641090554208861L;
        private String id;
        private String password;
    }
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;

    @GetMapping(value = "/login")
    public AbstractBaseResult loginl(test test) {
        User login = loginService.loginl(Long.valueOf(test.id),test.password);
        if(login == null){
            return error("账号密码错误");
        }else if(login.getNicename()==null || login.getNicename().equals("")){
            return error("该账户已登录");
        }
        //redis保存用户
        redisService.set2(login.getToken(), JsonUtils.objectToJson(login));
        return success("",login);
    }


}
