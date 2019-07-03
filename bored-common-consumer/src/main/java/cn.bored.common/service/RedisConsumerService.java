package cn.bored.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 12:07
 **/
@FeignClient(value = "bored-service-provider-redis",fallback = RedisConsumerServiceFallback.class)
public interface RedisConsumerService {

    @GetMapping("/redis/set")
     String set(String key,String value,int second);

     @GetMapping("/redis/set2")
     String set2(String key,String value);

    @GetMapping("/redis/get")
     String get(String key);

    @GetMapping("/redis/del")
     String del(String key,String value);

}
