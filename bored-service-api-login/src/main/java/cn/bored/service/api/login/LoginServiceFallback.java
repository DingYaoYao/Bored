package cn.bored.service.api.login;

import cn.bored.domain.User;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-08 11:03
 **/
@Component
public class LoginServiceFallback  implements  LoginService{
    @Override
    public User loginl(Long id, String password) {
        return null;
    }
}
