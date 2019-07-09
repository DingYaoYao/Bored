package cn.bored.api.redis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-08 22:17
 **/
@FeignClient(value = "bored-service-provider-redis",fallback = RedisServiceFallback.class)
public interface RedisService {

    @GetMapping("/set")
    String set(@RequestParam String key, @RequestParam  String value, @RequestParam  int second);

    @GetMapping("/set2")
    String set2(@RequestParam String key,@RequestParam String value);

    @GetMapping("/get")
    String get(@RequestParam String key);

    @GetMapping("/del")
    String del(@RequestParam String key);
}
