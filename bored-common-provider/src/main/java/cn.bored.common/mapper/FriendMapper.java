package cn.bored.common.mapper;

import cn.bored.domain.Friend;
import mapper.MyMapper;

import java.util.List;

public interface FriendMapper extends MyMapper<Friend> {

    //查询自己的朋友圈信息
    List<Friend> MyFriends(long userid);

    //查询自己朋友的朋友圈信息
    List<Friend> MyfriendFriends(long userid);

    //给朋友圈点赞
    int updateFriendlike(long userid);
}
