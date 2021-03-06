package cn.bored.service.api.user;


import cn.bored.common.dto.DtoResult;
import cn.bored.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "bored-service-provider-userupdate",fallback = UserServiceFallback.class)
public interface UserService{

     @GetMapping("/user/token/{token}")
     DtoResult<User> getUserByToken(@PathVariable String token);
     @GetMapping("/user/id/{id}")
     DtoResult<User> getUserById(@PathVariable long id);
     @PostMapping("/user/update")
     DtoResult<User> update(@RequestBody User tbUser);
}
