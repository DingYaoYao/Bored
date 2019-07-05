package cn.bored.service.provider.pal.service;

import cn.bored.common.service.BaseService;
import cn.bored.domain.Apply;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.Friends;

import java.util.List;

public interface PalService<T extends BaseEntity> extends BaseService<T> {
    //查询一个用户的好友
    List<Friends> getFriendsdDecided(long id);
    //双向添加
    int Friendsadd(Long id,String Friendsid);
    //双向删除
    int Friendsdel(Long id,String Friendsid);
}
