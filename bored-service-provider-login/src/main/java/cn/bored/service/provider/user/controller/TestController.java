package cn.bored.service.provider.user.controller;

import cn.bored.domain.User;
import cn.bored.service.provider.user.service.UserService;
import lombok.var;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    //判断用户登录 成功更新--登录时间/登录状态
    @PostMapping(value = "/login")
    public String loginl( Long id, String password) throws ParseException {

        User user;
     //   long lid = Long.parseLong(id);
        user = userService.userlogin(id,password);
        Map<String, Object> map = new HashMap<>();

        if(id == user.getId() || password == user.getPassword()){

            user.setLoginstat(1);
            user.setLatelyLoginDate(new Date());
            int stat = userService.updateLoginStat(user);
            if(stat>=1){
                map.put("error", "登录成功");
                var params = JSON.toJSONString(map);
                return JSON.toJSONString(map);
            }else {
                System.out.println("用户状态更新失败！");
                map.put("error", "登录异常");
                return JSON.toJSONString(map);
            }
        }
        map.put("error", "用户账号或密码错误");
        return JSON.toJSONString(map);
    }
}
