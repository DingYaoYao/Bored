package cn.bored.service.consumer.reg.service;


import cn.bored.common.dto.DtoResult;
import cn.bored.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "bored-service-provider-reg",fallback = RegConsumerServiceFallback.class)
public interface RegConsumerService {
    @GetMapping("/reg/test")
    String test();

    //这个的对应bored-service-provider-reg  controll中的路径   类型不对
    @PostMapping(value ="/reg/useradd")
    DtoResult<User> regz(@RequestBody User tbUser);

}
