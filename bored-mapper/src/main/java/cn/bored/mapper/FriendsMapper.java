package cn.bored.mapper;

import cn.bored.domain.Apply;
import cn.bored.domain.Friends;
import mapper.MyMapper;

import java.util.List;

public interface FriendsMapper extends MyMapper<Friends> {

    //查询我的好友
    List<Friends> getFriendsDecided(long id);
    //双向删除
    int Friendsdel(Long id,String Friendsid);
}
