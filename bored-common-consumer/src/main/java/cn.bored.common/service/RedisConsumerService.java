package cn.bored.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 12:07
 **/
@FeignClient(value = "bored-service-provider-redis",fallback = RedisConsumerServiceFallback.class)
public interface RedisConsumerService {

    @GetMapping("/redis/set")
     String set(@RequestParam  String key, @RequestParam  String value, @RequestParam  int second);

     @GetMapping("/redis/set2")
     String set2(@RequestParam String key,@RequestParam String value);

    @GetMapping("/redis/get")
     String get(@RequestParam String key);

    @GetMapping("/redis/del")
     String del(@RequestParam String key,@RequestParam String value);

}
