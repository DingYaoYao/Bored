package cn.bored.common.service.impl;

import cn.bored.common.mapper.UserMapper;
import cn.bored.common.service.TbUserService;
import cn.bored.domain.User;

import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl extends BaseCrudServiceImpl<User, UserMapper> implements TbUserService {
}
