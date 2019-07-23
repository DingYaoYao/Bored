package cn.bored.common.mapper;

import cn.bored.domain.Space;
import cn.bored.domain.Topic;
import cn.bored.domain.User;
import mapper.MyMapper;


public interface SpaceMapper extends MyMapper<Space> {

    User userspace(long id, long titleid);

    int insertTopic(Topic topic);

    int insertSpace(Topic topic);

    Topic selectTopic(Topic topic);
}

