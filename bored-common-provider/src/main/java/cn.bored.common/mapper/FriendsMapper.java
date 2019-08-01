package cn.bored.common.mapper;

import cn.bored.domain.Friends;
import mapper.MyMapper;

import java.util.List;

public interface FriendsMapper extends MyMapper<Friends> {

    int add(Friends friends);
    //查询我的好友
    List<Friends> getFriendsDecided(Long id);
    //双向删除
    int Friendsdel(Long id, Long Friendsid);
}
