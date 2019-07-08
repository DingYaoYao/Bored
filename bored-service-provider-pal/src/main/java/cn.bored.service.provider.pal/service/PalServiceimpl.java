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
    public List<Friends> getFriendsdDecided(long id) {
        return friendsMapper.getFriendsDecided(id);
    }
    @Override
    public int Friendsadd(Long id, String Friendsid) {
        Friends friends=new Friends();
        friends.setId(id);
        friends.setFriendUserId(Friendsid);
        int resut= friendsMapper.insert(friends);
        Friends friendsa=new Friends();
        long l = Long.parseLong(Friendsid);
        friendsa.setId(l);
        friendsa.setFriendUserId(id.toString());
        int resuat= friendsMapper.insert(friendsa);
        return resut+resuat;
    }
    @Override
    public int Friendsdel(Long id, String Friendsid) {
        return friendsMapper.Friendsdel(id,Friendsid);
    }
}
