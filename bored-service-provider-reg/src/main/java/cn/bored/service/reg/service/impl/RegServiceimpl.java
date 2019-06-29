package cn.bored.service.reg.service.impl;

import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.User;
import cn.bored.mapper.UserMapper;
import cn.bored.service.reg.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegServiceimpl extends BaseServiceImpl<User,UserMapper> implements RegService<User>{
    @Autowired
    private UserMapper userMapper;
}

