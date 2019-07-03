package cn.bored.service.userupdate.service;

import cn.bored.common.service.BaseService;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.User;
public interface UserService<T extends BaseEntity> extends BaseService<T> {

    public User getUserByToken(String token);
    public User save(User domain);
}