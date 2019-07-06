package cn.bored.service.provider.user.controller;

import cn.bored.domain.User;
import cn.bored.service.provider.user.service.UserService;
import lombok.var;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
//@Controller
//@ResponseBody
@RestController
public class TestController {

    @Autowired
    private UserService<User> userService;


    //判断用户登录 成功更新--登录时间/登录状态
    @PostMapping(value = "/login")
    public User loginl(Long id, String password) {

        Map<String, Object> map = new HashMap<>();
        User user;
        user = userService.userlogin(id, DigestUtils.md5DigestAsHex(password.getBytes()));
      if(!StringUtils.isEmpty(user)){
          Integer stat = userService.LoginStat(id);
         if(stat !=1 ){
             user.setLoginstat(1);
             user.setLatelyLoginDate(new Date());
             int datastat = userService.updateLoginStat(user);
             if(datastat >= 1){
                 return user;
             }
         }
          return new User();
      }
        return null;
    }
}
