package cn.bored.service.consumer.Pal.controller;

import cn.bored.service.api.pal.PalService;
import cn.bored.common.dto.DtoResult;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Friends;
import cn.bored.domain.User;
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
    private PalService palService;

    //获取好友列表
    @GetMapping("/GetuserPal")
    public DtoResult<List<Friends>> GetuserPal() {
        User user = ConsumerConstant.getUser(request);
        List<Friends> friends = palService.getFriendsdDecided(user.getId());
        return friends == null ? success("用户没有好友，或执行失败") : success(friends);
    }

//    //执行双向添加
//    @PostMapping("/addPal")
//    public DtoResult addPal(@RequestParam Long id, Long Friendsid) {
//        User user = ConsumerConstant.getUser(request);
//        if (user.getId() == id) {
////            int resut=palService.AddPAl(id,Friendsid);
////            if (resut>=2){
////                return  success();
////            }else{
////                return error("双向添加失败");
////            }
//            palService.Friendsadd(user.getId(),)
//        } else {
//            return error("没有权限");
//        }
//        return null;
//    }

    //执行双向删除
    @GetMapping("/delPal")
    public DtoResult<Friends> delPal(@RequestParam Long id,@RequestParam Long Friendsid) {
        User user = ConsumerConstant.getUser(request);

        if (user.getId().equals(id) ) {
            DtoResult friendsdel = palService.Friendsdel(id, Friendsid);
            return templete(friendsdel);
        } else {
            return error("没有权限");
        }
    }
}
