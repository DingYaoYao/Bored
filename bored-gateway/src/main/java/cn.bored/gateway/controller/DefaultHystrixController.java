package cn.bored.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认降级处理
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultfallback")
    public Map<String,String> defaultfallback(){
        System.out.println("降级操作...");
        Map<String,String> map = new HashMap<>();
        map.put("code","202");
        map.put("message","服务异常");
        map.put("data","null");
        return map;
    }
}
