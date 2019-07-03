package cn.bored.common.service;

import cn.bored.domain.User;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 13:56
 **/
public class UserConsumerServiceFallback implements UserConsumerService {
    @Override
    public User getUserByToken(String token) {
        return null;
    }
}
