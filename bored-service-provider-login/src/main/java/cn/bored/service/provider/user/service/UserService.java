package cn.bored.service.provider.user.service;

import cn.bored.common.service.BaseService;
import cn.bored.domain.BaseEntity;
import cn.bored.domain.User;

public interface UserService<T extends BaseEntity> extends BaseService<T> {
    //用户登录
    User userlogin(Long id,String password);
    //更新登录后的状态 、 时间
    int updateLoginStat(User user);
    //查询用户登录状态
    Integer LoginStat(Long id);
}
