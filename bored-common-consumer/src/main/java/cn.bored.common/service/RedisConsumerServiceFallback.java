package cn.bored.common.service;

import org.springframework.boot.autoconfigure.cache.CacheProperties;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 12:08
 **/
public class RedisConsumerServiceFallback  implements RedisConsumerService {
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
    public String del(String key, String value) {
        return null;
    }
}
