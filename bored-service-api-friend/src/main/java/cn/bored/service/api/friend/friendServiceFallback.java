package cn.bored.service.api.friend;

import cn.bored.domain.Friend;

import java.util.List;

public class friendServiceFallback implements friendService {


    @Override
    public List<Friend> myfriend(long userid) {
        return null;
    }

    @Override
    public List<Friend> myfriendFriends(long userid) {
        return null;
    }

    @Override
    public int addFriend(Friend friend) {
        return 0;
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public int updatelike(long userid) {
        return 0;
    }
}
