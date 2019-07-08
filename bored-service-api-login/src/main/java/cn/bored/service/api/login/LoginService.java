package cn.bored.service.api.login;

import cn.bored.domain.BaseEntity;
import cn.bored.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bored-service-provider-login",fallback =LoginServiceFallback.class )
public interface LoginService {

    //判断用户登录 成功更新--登录时间/登录状态
    @GetMapping(value = "/login")
    User loginl(@RequestParam  Long id, @RequestParam String password);

}
