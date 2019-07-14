package cn.bored.service.provider.user.service;

import cn.bored.service.api.login.LoginService;
import cn.bored.common.mapper.UserMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginServiceImpl extends BaseServiceImpl<User, UserMapper> implements LoginService {

    /**
     *
     */
    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/login")
    @Override
    public User loginl(Long id, String password) {
        System.out.println("privoder log");
        User user;
        user = userMapper.userlogin(id, DigestUtils.md5DigestAsHex(password.getBytes()));
        if(!StringUtils.isEmpty(user)){
            Integer stat = userMapper.LoginStat(id);
            if(stat ==null||stat==1 ){
                user.setLoginstat(1);
                user.setLatelyLoginDate(new Date());
                int datastat = userMapper.updateLoginStat(user);
                if(datastat >= 1){
                    user.setPassword("DingDingDingDing");
                    return user;
                }
            }
            return new User();
        }
        return null;
    }
}
