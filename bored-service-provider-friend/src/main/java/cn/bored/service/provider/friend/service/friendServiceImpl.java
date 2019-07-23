package cn.bored.service.provider.friend.service;

import cn.bored.common.dto.DtoResult;
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


    @GetMapping(value = "/myfriend/{userId}")
    @Override
    public List<Friend> myfriend(@PathVariable long userId) {
        return friendMapper.MyFriends(userId);
    }

    @GetMapping(value = "/myfriendFriends/{userId}")
    @Override
    public List<Friend> myfriendFriends(@PathVariable long userId) {
        return friendMapper.MyfriendFriends(userId);
    }

    @PostMapping(value = "add")
    @Override
    public DtoResult addFriend(@RequestBody Friend friend) {
        friend.setCreatetime(new Date());
        friend.setLike(0);
        return result(friendMapper.addFriend(friend), "添加朋友圈失败！");
    }

    @GetMapping(value = "/del/{id}")
    @Override
    public DtoResult del(@PathVariable int id) {
        return result(friendMapper.delFriend(id), "删除朋友圈失败！");
    }

    @GetMapping(value = "/updatelike/{id}")
    @Override
    public DtoResult updatelike(@PathVariable long id) {
        return result(friendMapper.updateFriendlike(id), "点赞失败！");
    }

    public DtoResult result(int result, String message) {
        if (result <= 0) {
            return abstractBaseController.error(message);
        }
        return abstractBaseController.success();
    }
}
