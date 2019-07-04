package cn.bored.service.provider.friend.service.serviceImpl;

import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.Friend;
import cn.bored.mapper.FriendMapper;
import cn.bored.service.provider.friend.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class friendServiceImpl extends BaseServiceImpl<Friend, FriendMapper> implements friendService<Friend> {

    @Autowired
    private FriendMapper friendMapper;


    @Override
    public List<Friend> MyFriends(long userid) {
        return friendMapper.MyFriends(userid);
    }

    @Override
    public List<Friend> MyfriendFriends(long userid) {
        return friendMapper.MyfriendFriends(userid);
    }

    @Override
    public int updateFriendlike(long userid) {
        return friendMapper.updateFriendlike(userid);
    }

}
