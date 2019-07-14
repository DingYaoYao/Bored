package cn.bored.service.consumer.Pal.controller;

import cn.bored.common.dto.DtoResult;
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
@RequestMapping("/pal")
public class PalController extends AbstractBaseController {

    @Autowired
    private PalConsumerService palConsumerService;
    //获取好友列表
    @GetMapping("/GetuserPal")
    public DtoResult<List<Friends>> GetuserPal(){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        List<Friends> friends= palConsumerService.GetuserPal(user.getId());
        return friends==null?error("用户没有好友，或执行失败"):success(friends);
    }
    //执行双向添加
    @PostMapping("/addPal")
    public DtoResult addPal(@RequestParam Long id, Long Friendsid){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        if (user.getId()==id){
            int resut=palConsumerService.AddPAl(id,Friendsid);
            if (resut>=2){
                return  success();
            }else{
                return error("双向添加失败");
            }
        }else{
            return  error("没有权限");
        }
    }
    //执行双向删除
    @PostMapping("/delPal")
    public DtoResult<Friends> delPal(@RequestParam Long id, Long Friendsid){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        if (user.getId()==id){
            int resut=palConsumerService.delPal(id,Friendsid);
        if(resut>=2){
            return success();
        }else{
            return error("双向删除失败");
        }
        }else{
            return  error("没有权限");
        }
    }

}
