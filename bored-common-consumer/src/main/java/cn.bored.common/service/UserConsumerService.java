package cn.bored.common.service;

import cn.bored.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 13:52
 **/
@FeignClient(value = "bored-service-provider-userupdate",fallback = UserConsumerServiceFallback.class)
public interface UserConsumerService {

    @GetMapping("/getUserByToken")
     User getUserByToken(@RequestParam  String token);
}
