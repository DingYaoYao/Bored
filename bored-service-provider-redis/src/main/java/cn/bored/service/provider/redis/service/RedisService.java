package cn.bored.service.provider.redis.service;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 11:37
 **/
public interface RedisService {

    /**
     * 设置缓存
     * @param key
     * @param value
     */
    void set(String key, Object value);

    /**
     * 设置缓存
     * @param key
     * @param value
     * @param seconds 缓存有效期
     */
    void set(String key, Object value, int seconds);

    /**
     * 获取缓存
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 删除缓存
     * @param key
     */
    Boolean delete(String key);
}
