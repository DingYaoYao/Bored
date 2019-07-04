package cn.bored.common.service;

import cn.bored.domain.User;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 13:56
 **/
@Component
public class UserConsumerServiceFallback implements UserConsumerService {
    @Override
    public User getUserByToken(String token) {
        return null;
    }
}
