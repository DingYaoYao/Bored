package cn.bored.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-26 09:46
 **/
@Controller
public class UserController {

    @RequestMapping("/friendInfo/{id}")
    public String to_Friends(Model model, @PathVariable long id){
        System.out.println("展示好友信息！。。。");
        model.addAttribute("userId",id);
        return "friendInfo";
    }
    @RequestMapping("/xin")
    public String to_FriendsInfo(HttpServletRequest request){
        System.out.println("新朋友界面！。。。");
        return "newPriend";
    }
    @RequestMapping("/addUserFriends")
    public String to_addUserFriends(HttpServletRequest request){
        System.out.println("去添加好友界面！。。。");
        return "addUserFriends";
    }
    @RequestMapping("/circle")
    public String to_Circle(HttpServletRequest request){
        System.out.println("去朋友圈界面！。。。");
        return "circle";
    }
    @RequestMapping("/addCircle")
    public String to_addCircle(HttpServletRequest request){
        System.out.println("去添加朋友圈界面！。。。");
        return "addCircle";
    }
    @RequestMapping("/userInfo")
    public String to_userInfo(){
        System.out.println("去添加朋友圈界面！。。。");
        return "userInfo";
    }
    @RequestMapping("/danliao/{id}")
    public String to_danliao(Model model, @PathVariable long id){
        System.out.println("聊天页面！。。。");
        model.addAttribute("userId",id);
        return "danliao";
    }

}
