package cn.bored.mapper;


import cn.bored.domain.User;
import mapper.MyMapper;
public interface UserMapper extends MyMapper<User> {

    User userlogin(User user);
}
