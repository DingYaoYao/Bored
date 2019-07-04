package cn.bored.service.provider.redis.controller;

import cn.bored.service.provider.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 11:42
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/set")
    public String set(String key,String value,int second){
        redisService.set(key,value,second);
        return "ok";
    }
    @RequestMapping("/set2")
    public String set2(String key,String value){
        redisService.set(key,value,60*60*24);
        return "ok";
    }
    @RequestMapping("/get")
    public String get(String key){
        Object o = redisService.get(key);
        System.out.println("redis getvalue key--->"+key+"  value----->"+o);
        if(o!=null){
            return String.valueOf(o);
        }
        return null;
    }
    @RequestMapping("/del")
    public String del(String key,String value){
        return  redisService.delete(key)?"ok":null;
    }

}
