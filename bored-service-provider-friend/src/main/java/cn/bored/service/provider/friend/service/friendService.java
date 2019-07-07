package cn.bored.service.provider.friend.service;

import cn.bored.common.service.BaseService;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.Friend;

import java.util.List;

public interface friendService<T extends BaseEntity> extends BaseService<T> {
    //查询自己的朋友圈信息
    List<Friend> MyFriends(long userid);

    //查询自己朋友的朋友圈信息
    List<Friend> MyfriendFriends(long userid);

    //给朋友圈点赞
    int updateFriendlike(long userid);

    //添加朋友圈
    int addFriend(Friend friend);

    //删除朋友圈
    int delFriend(int id);

}
