package cn.bored.service.provider.user.controller;

import cn.bored.domain.User;
import cn.bored.service.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String test(HttpServletRequest request){

        HttpSession session = request.getSession();
        Object sesssionValue = session.getAttribute("test");

        System.out.println("进入方法------------");
        System.out.println("获得session---------"+session);
        System.out.println("获得回话值----------"+sesssionValue);
        System.out.println("----------------------------\n\n");
        System.out.println("privider user serive value===>"+userService);
        return "hello word";
    }
    @GetMapping(value = "/login")
    public String loginl(User user){
        return "登陆成功！";
    }
}
