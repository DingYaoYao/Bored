package cn.bored.service.consumer.user.consumer;

import org.springframework.stereotype.Component;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-28 17:48
 **/
@Component
public class UserConsumerServiceFallback  implements  UserConsumerService{

    @Override
    public  String test(){
        return "fallback";
    }
}
