package cn.bored.common.mapper;


import cn.bored.domain.User;
import mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper<User> {

    User userlogin(User user);
    User getUserByToken(String token);

    //用户登录
    User userlogin(@Param("id") Long id,
                   @Param("password") String password);
    //获取登录后的状态 、 时间
    int updateLoginStat(User user);
}
