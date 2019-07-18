package cn.bored.service.consumer.userupdate.controller;
import cn.bored.service.api.user.UserService;
import cn.bored.common.dto.DtoResult;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserConsumerControll extends AbstractBaseController{

    @Autowired
    private UserService userService;

//    @PostMapping("/update")
//    public String update(User tbUser){
//        return userService.update(tbUser);
//    }

   //根据用户id获得用户信息
    @GetMapping("/getuser/{userid}")
    DtoResult<User> getuser(@PathVariable Long userid){
        DtoResult<User> getuser = userService.getUserById(userid);
        return templete(getuser);
    }
}
