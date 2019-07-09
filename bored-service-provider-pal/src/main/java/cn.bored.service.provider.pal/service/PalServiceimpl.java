package cn.bored.service.provider.pal.service;

import cn.bored.common.mapper.FriendMapper;
import cn.bored.common.mapper.FriendsMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalServiceimpl extends BaseServiceImpl<Friends, FriendsMapper> implements  PalService<Friends>{

    @Autowired
    private FriendsMapper friendsMapper;
    @Override
    public List<Friends> getFriendsdDecided(Long id) {
        return friendsMapper.getFriendsDecided(id);
    }
    @Override
    public int Friendsadd(Long id, Long Friendsid) {
        Friends friends=new Friends();
        friends.setUserid(id);
        friends.setFriendUserId(String.valueOf(Friendsid));
        int resut= friendsMapper.insert(friends);
        Friends friendsa=new Friends();
        friendsa.setUserid(Friendsid);
        friendsa.setFriendUserId(String.valueOf(id));
        int resuat= friendsMapper.insert(friendsa);
        int a=resut+resuat;
        return a;
    }
    @Override
    public int Friendsdel(Long id, Long Friendsid) {
            int resoulta=friendsMapper.Friendsdel(Friendsid,id);
        int resoultb=friendsMapper.Friendsdel(id,Friendsid);
        int a=resoulta+resoultb;
        return a;
    }
}
