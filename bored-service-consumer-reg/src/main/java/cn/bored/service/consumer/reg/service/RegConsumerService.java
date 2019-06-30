package cn.bored.service.consumer.reg.service;

import cn.bored.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bored-service-provider-reg",fallback = RegConsumerServiceFallback.class)
public interface RegConsumerService {
    @GetMapping("/reg/test")
    String test();


    //这个的对应bored-service-provider-reg  controll中的路径
    @PostMapping(value ="/reg/useradd")
    String regz(@RequestParam("tbUser") User tbUser);
}
