package cn.bored.service.provider.redis.service;

import cn.bored.api.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 11:38
 **/
@RestController
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @RequestMapping("/set")
    public String set(String key, String value, int second) {
        try {
            redisTemplate.opsForValue().set(key,value,second);
        } catch (Exception e) {
            e.printStackTrace();
           return null;
        }
        return "ok";
    }

    @Override
    @RequestMapping("/set2")
    public String set2(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key,value,60*60*24,TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "ok";
    }

    @Override
    @RequestMapping("/get")
    public String get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        System.out.println("redis get value  key===>"+key+"    vlue==>"+o);
        return o==null?null:String.valueOf(o);
    }

    @Override
    @RequestMapping("/del")
    public String del(String key) {
        Boolean delete = redisTemplate.delete(key);
        return delete?"ok":null;
    }
}
