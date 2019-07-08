package cn.bored.service.consumer.Pal.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Friends;
import cn.bored.domain.User;
import cn.bored.service.consumer.Pal.service.PalConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 * @author: Ding
 * @create: 2019-07-03 14:54
 **/
@RestController
@RequestMapping("/Pal")
public class PalController extends AbstractBaseController<Friends> {

    @Autowired
    private PalConsumerService palConsumerService;
        //获取好友列表
    @GetMapping("/GetuserPal")
    public AbstractBaseResult GetuserPal(){
      //  User user = ConsumerConstant.getUser(request);
      //  if(user==null)return userError();
       // List<Friends> friends= palConsumerService.GetuserPal(user.getid());
        Long i=Long.getLong("1");
        List<Friends> friends= palConsumerService.GetuserPal(i);
        return friends.size()==0?error("用户没有好友，或执行失败"):success(friends);
    }
    //执行双向添加
    @PostMapping("/addPal")
    public AbstractBaseResult AddPAl(@RequestParam Long id, String Friendsid){
        int resut=palConsumerService.AddPAl(id,Friendsid);
        return resut==2?success():error("添加失败");
    }
    //执行双向删除
    @PostMapping("/delPal")
    public AbstractBaseResult delPal(@RequestParam Long id,String Friendsid){

        int resut=palConsumerService.delPal(id,Friendsid);
        return resut==2?success():error("删除失败");
    }



}