package cn.bored.service.provider.user.service;

import cn.bored.common.mapper.UserMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService<User> {

    /**
     *
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public User userlogin(Long id,String password) {
        User login = userMapper.userlogin(id,password);
        return login;
    }

    @Override
    public int updateLoginStat(User user) {
        int result = userMapper.updateLoginStat(user);
        return result;
    }
}
