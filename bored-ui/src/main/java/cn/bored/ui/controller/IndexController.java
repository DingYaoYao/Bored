package cn.bored.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-25 12:29
 **/
@Controller
public class IndexController {

    @RequestMapping("/login")
    public String to_Login(){
        System.out.println("去登陆界面！。。。");
        return "login";
    }
    @RequestMapping("/register")
    public String to_Register(){
        System.out.println("去注册界面！。。。");
        return "register";
    }
    @RequestMapping("/main")
    public String to_Main(){
        System.out.println("去zhu界面！。。。");
        return "index";
    }
}
