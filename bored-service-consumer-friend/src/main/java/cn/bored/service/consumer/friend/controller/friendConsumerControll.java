package cn.bored.service.consumer.friend.controller;

import cn.bored.common.dto.AbstractBaseResult;
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
public class friendConsumerControll extends AbstractBaseController<Friend> {

    @Autowired
    private friendService friendService;

    @GetMapping(value = "/myfriend")
    public AbstractBaseResult myfriend(HttpServletRequest request){
        User user = ConsumerConstant.getUser(request);
        if(user==null) return userError();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        List<Friend> friends = friendService.myfriend(user.getId());

        return friends==null?sentinelError():success(friends);
    }

    @GetMapping(value = "/myfriendFriends")
    public AbstractBaseResult myfriendFriends(HttpServletRequest request){
        User user = ConsumerConstant.getUser(request);
        if (user==null) return userError();

        List<Friend> friends = friendService.myfriendFriends(user.getId());
        return friends==null?sentinelError():success(friends);
    }

    @PostMapping (value = "/add")
    public AbstractBaseResult add(Friend friend){
        int add = friendService.addFriend(friend);
        return add==0?error("添加朋友圈失败"):success();
    }

    @GetMapping(value = "/del")
    public AbstractBaseResult del(int id){
        int del = friendService.del(id);
        return del==0?error("删除朋友圈失败"):success();
    }

    @GetMapping(value = "/updatelike")
    public AbstractBaseResult updatelike(HttpServletRequest request){
        User user = ConsumerConstant.getUser(request);
        if (user==null) return userError();
        int updatelike = friendService.updatelike(user.getId());
        return updatelike==0?error("点赞失败"):success();
    }

}
