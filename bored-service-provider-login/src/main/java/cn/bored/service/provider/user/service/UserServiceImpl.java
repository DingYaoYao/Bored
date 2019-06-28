package cn.bored.service.provider.user.service;

import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.User;
import cn.bored.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService<User> {

    @Autowired
    private UserMapper userMapper;

    void test() {


    }


}
