package cn.bored.service.reg.service;

import cn.bored.common.service.BaseService;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.User;

public interface RegService <T extends BaseEntity> extends BaseService<T> {
    public User save(User domain);
}
