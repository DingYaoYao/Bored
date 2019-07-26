package cn.bored.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/searchFriendInfo")
    public String to_FriendsInfo(HttpServletRequest request){
        System.out.println("搜索好友信息！。。。");
        return "searchFriendInfo";
    }
    @RequestMapping("/addUserFriends")
    public String to_addUserFriends(HttpServletRequest request){
        System.out.println("去添加好友界面！。。。");
        return "haoyouxinxi";
    }

}
