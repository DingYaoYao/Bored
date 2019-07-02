package cn.bored.service.userupdate.service.impl;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.service.TbUserService;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import cn.bored.mapper.UserMapper;
import cn.bored.service.userupdate.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegServiceimpl extends BaseServiceImpl<User,UserMapper> implements RegService<User>{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TbUserService tbUserService;

    @Override
    public AbstractBaseResult userupdate(User user) {


        return null;
    }
}

