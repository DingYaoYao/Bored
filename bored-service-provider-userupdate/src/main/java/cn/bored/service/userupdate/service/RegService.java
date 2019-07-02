package cn.bored.service.userupdate.service;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.service.BaseService;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.User;

public interface RegService <T extends BaseEntity> extends BaseService<T> {
    AbstractBaseResult  userupdate(User tbuser);
}
