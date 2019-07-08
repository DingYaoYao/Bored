package cn.bored.service.provider.friend.controller;

import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Friend;
import cn.bored.service.provider.friend.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController extends AbstractBaseController<Friend> {

    @Autowired
    private friendService<Friend> friendService;

    @GetMapping(value = "/myfriend")
    public List<Friend> myfriend(long userid){
        List<Friend> friends = friendService.MyFriends(userid);
        for (Friend  friend :friends){
            System.out.println(friend.getContext());
        }

        return friends;
    }
    @GetMapping(value = "/myfriendFriends")
    public List<Friend> myfriendFriends(long userid){

        List<Friend> list = friendService.MyfriendFriends(userid);
        for (Friend lists :list) {
            System.out.println(lists.getContext());
        }
        return list;
    }

    @PostMapping(value = "/add")
    public int addFriend(@RequestBody Friend friend){
        friend.setCreatetime(new Date());
        return friendService.addFriend(friend);
    }

    @GetMapping(value = "/del")
    public int del(int id){
         return friendService.delFriend(id);
    }

    @GetMapping(value = "/updatelike")
    public int updatelike(long userid){

        int i = friendService.updateFriendlike(userid);
        if(i<0){
            //点赞失败
            return 0;
        }
        //点赞成功
        return i;
    }
}
