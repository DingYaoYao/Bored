package cn.bored.service.consumer.apply;

import cn.bored.domain.BaseEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 18:34
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BoredServiceConsumerApplyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceConsumerApplyApplication.class,args);
    }
}
