package cn.bored.service.consumer.friend.service;

import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Friend;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class friendConsumerServiceFallback extends AbstractBaseController implements friendConsumerService {


    @Override
    public List<Friend> myfriend(long userid) {
        System.out.println("进入熔断//////////////////////////////////////////////////////");
        return null;
    }

    @Override
    public List<Friend> myfriendFriends(long userid) {
        System.out.println("进入熔断//////////////////////////////////////////////////////");
        return null;
    }

    @Override
    public int addFriend(Friend friend) {
        return 0;
    }


    @Override
    public int del(int id) {
        System.out.println("进入熔断////////////////////////////////////////");
        return 0;
    }


    @Override
    public int updatelike(long userid) {
        System.out.println("进入熔断//////////////////////////////////////////////////////");
        return 0;
    }
}
