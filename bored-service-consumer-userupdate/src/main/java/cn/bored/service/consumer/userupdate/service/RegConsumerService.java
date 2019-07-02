package cn.bored.service.consumer.userupdate.service;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bored-service-provider-userupdate",fallback = RegConsumerServiceFallback.class)
public interface RegConsumerService {

    @PostMapping(value ="/user/update")
    String update(@RequestBody User tbUser);
}
