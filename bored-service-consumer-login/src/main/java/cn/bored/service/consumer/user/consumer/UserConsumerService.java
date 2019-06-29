package cn.bored.service.consumer.user.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-28 17:47
 **/
@FeignClient(value = "bored-service-provider-login",fallback = UserConsumerServiceFallback.class)
public interface UserConsumerService {

    @GetMapping("/test")
     String test();

}
