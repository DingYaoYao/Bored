package cn.bored.service.api.friend;

import cn.bored.common.dto.DtoResult;
import cn.bored.domain.Friend;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
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
    public DtoResult addFriend(Friend friend) {
        return null;
    }

    @Override
    public DtoResult del(int id) {
        return null;
    }

    @Override
    public DtoResult updatelike(long userid) {
        return null;
    }
}
