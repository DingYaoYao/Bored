package cn.bored.service.consumer.friend.controller;

import cn.bored.common.dto.DtoResult;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Friend;
import cn.bored.domain.User;
import cn.bored.service.api.friend.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "friend")
public class friendConsumerControll extends AbstractBaseController {

    @Autowired
    private friendService friendService;

    @GetMapping(value = "/myfriend")
    public DtoResult< List<Friend>> myfriend(HttpServletRequest request){
        User user = ConsumerConstant.getUser(request);
         List<Friend> friends = friendService.myfriend(user.getId());
        return friends==null?error():success(friends);
    }

    @GetMapping(value = "/myfriendFriends")
    public DtoResult myfriendFriends(HttpServletRequest request){
        User user = ConsumerConstant.getUser(request);
        List<Friend> friends = friendService.myfriendFriends(user.getId());
        return friends==null?error():success(friends);
    }

    @PostMapping (value = "/add")
    public DtoResult add(Friend friend){
        User user = ConsumerConstant.getUser(request);
        friend.setUserid(user.getId());
        DtoResult dtoResult = friendService.addFriend(friend);
      return templete(dtoResult);

    }

    @GetMapping(value = "/del/{id}")
    public DtoResult del(@PathVariable int id){
        DtoResult del = friendService.del(id);
     return    templete(del);
     //  return del==0?error("删除朋友圈失败"):success();
    }

    @GetMapping(value = "/updatelike/{friendId}")
    public DtoResult updatelike(HttpServletRequest request,@PathVariable int friendId){
        User user = ConsumerConstant.getUser(request);
        DtoResult updatelike = friendService.updatelike(friendId);
        return templete(updatelike);
       // return updatelike==0?error("点赞失败"):success();
    }

}
