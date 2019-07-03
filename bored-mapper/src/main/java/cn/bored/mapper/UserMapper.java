package cn.bored.mapper;


import cn.bored.domain.User;
import mapper.MyMapper;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
public interface UserMapper extends MyMapper<User> {

    User userlogin(User user);
    User getUserByToken(String token);
>>>>>>> 5dc9446b9cfcdce0b121cac6fdcbc0171f2c8b3f

public interface UserMapper extends MyMapper<User> {
    //用户登录
    User userlogin(@RequestParam("id") Long id,
                   @RequestParam("password") String password);
    //获取登录后的状态 、 时间
    int updateLoginStat(User user);
}
