package cn.bored.api.redis;

import org.springframework.stereotype.Component;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-08 22:18
 **/
@Component
public class RedisServiceFallback  implements RedisService{
    @Override
    public String set(String key, String value, int second) {
        return null;
    }

    @Override
    public String set2(String key, String value) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String del(String key) {
        return null;
    }
}
