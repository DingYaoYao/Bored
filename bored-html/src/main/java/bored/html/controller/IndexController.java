package bored.html.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String to_Main(HttpServletRequest request){
        System.out.println("去zhu界面！。。。");
//        Object bored1 = request.getAttribute("BORED");
//        r
//        Object bored = request.getSession().getAttribute("BORED");
//        if(StringUtils.isEmpty(bored)){
//            return "redirect:login";
//        }
        return "index";
    }


}
