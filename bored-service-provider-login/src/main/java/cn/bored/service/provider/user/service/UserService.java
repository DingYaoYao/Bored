package cn.bored.service.provider.user.service;

import cn.bored.common.service.BaseService;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.User;

public interface UserService<T extends BaseEntity> extends BaseService<T> {
    User userlogin(User user);
}
