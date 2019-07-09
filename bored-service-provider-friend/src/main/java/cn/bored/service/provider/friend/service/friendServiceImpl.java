package cn.bored.service.provider.friend.service;

import cn.bored.common.mapper.FriendMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.Friend;

import cn.bored.service.api.friend.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/friend")
public class friendServiceImpl extends BaseServiceImpl<Friend, FriendMapper> implements friendService {

    @Autowired
    private FriendMapper friendMapper;


    @GetMapping(value = "/myfriend")
    @Override
    public List<Friend> myfriend(long userid) {
        return friendMapper.MyFriends(userid);
    }

    @GetMapping(value = "/myfriendFriends")
    @Override
    public List<Friend> myfriendFriends(long userid) {
        return friendMapper.MyfriendFriends(userid);
    }

    @PostMapping(value = "add")
    @Override
    public int addFriend(@RequestBody Friend friend) {
        friend.setCreatetime(new Date());
        return friendMapper.addFriend(friend);
    }


    @GetMapping(value = "/del")
    @Override
    public int del(int id) {

        return friendMapper.delFriend(id);
    }

    @GetMapping(value = "/updatelike")
    @Override
    public int updatelike(long userid) {
        return friendMapper.updateFriendlike(userid);
    }
}
