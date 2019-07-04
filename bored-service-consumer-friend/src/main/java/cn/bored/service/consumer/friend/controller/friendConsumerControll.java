package cn.bored.service.consumer.friend.controller;

import cn.bored.domain.Friend;
import cn.bored.service.consumer.friend.service.friendConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "friend")
public class friendConsumerControll {

    @Autowired
    private friendConsumerService friendService;

    @GetMapping(value = "/myfriend")
    public List<Friend> myfriend(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        List<Friend> friends = friendService.myfriend(1);

       /* List<String> b=new ArrayList();
        b.add("wang");
        b.add("shuai");
        b.add("wei");*/
        return friends;
    }

    @GetMapping(value = "/myfriendFriends")
    public List<Friend> myfriendFriends(@RequestParam long userid){
        return friendService.myfriendFriends(userid);
    }

    @PostMapping(value = "/add")
    public int add(@RequestBody Friend friend){
        return friendService.add(friend);
    }

    @GetMapping(value = "/del")
    public int del(@RequestBody Friend friend){
        return friendService.del(friend);
    }

    @GetMapping(value = "/friend/updatelike")
    public int updatelike(@RequestParam long userid){
        return friendService.updatelike(userid);
    }

}
