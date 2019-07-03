package cn.bored.service.userupdate.service;

import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.User;
import cn.bored.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 13:41
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService<User>  {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByToken(String token) {
        return userMapper.getUserByToken(token);
    }
}
