package cn.bored.service.provider.user.controller;

import cn.bored.domain.User;
import cn.bored.service.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-28 17:14
 **/
@RestController
@Controller
public class TestController {

    @Autowired
    private UserService<User> userService;

    @GetMapping("/test")
    public String test(){
        System.out.println("privider user serive value===>"+userService);
        return "hello word";
    }
}
