package cn.bored.service.consumer.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BoredServiceConsumerFriendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceConsumerFriendApplication.class,args);
    }
}
