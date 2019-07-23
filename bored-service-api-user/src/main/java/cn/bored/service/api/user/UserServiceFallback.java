package cn.bored.service.api.user;

import cn.bored.common.dto.DtoResult;
import cn.bored.domain.User;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-16 21:56
 **/
@Component
public class UserServiceFallback implements UserService {
    @Override
    public DtoResult<User> getUserByToken(String token) {
        return null;
    }

    @Override
    public DtoResult<User> getUserById(long id) {
        return null;
    }

    @Override
    public DtoResult<User> update(User tbUser) {
        return null;
    }
}
