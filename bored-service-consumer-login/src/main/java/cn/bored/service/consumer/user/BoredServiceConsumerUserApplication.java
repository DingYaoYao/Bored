package cn.bored.service.consumer.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-28 17:42
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BoredServiceConsumerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceConsumerUserApplication.class,args);
    }
}
