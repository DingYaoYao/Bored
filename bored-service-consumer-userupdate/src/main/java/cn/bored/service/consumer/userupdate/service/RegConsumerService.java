package cn.bored.service.consumer.userupdate.service;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bored-service-provider-userupdate",fallback = RegConsumerServiceFallback.class)
public interface RegConsumerService {

    //这个的对应bored-service-provider-reg  controll中的路径   类型不对
    @PostMapping(value ="/user/update")
    AbstractBaseResult update(@RequestParam("tbUser") User tbUser);
}
