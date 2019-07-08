package cn.bored.service.consumer.friend.service;

import cn.bored.domain.Friend;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "bored-service-provider-friend",fallback = friendConsumerServiceFallback.class)
public interface  friendConsumerService {

    @GetMapping(value = "/friend/myfriend")
    public List<Friend> myfriend(@RequestParam long userid);

    @GetMapping(value = "/friend/myfriendFriends")
    public List<Friend> myfriendFriends(@RequestParam long userid);

    @PostMapping(value = "/friend/add")
    public int addFriend(@RequestBody Friend friend);

    @GetMapping(value = "/friend/del")
    public int del(@RequestParam int id);

    @GetMapping(value = "/friend/updatelike")
    public int updatelike(@RequestParam long userid);
}
