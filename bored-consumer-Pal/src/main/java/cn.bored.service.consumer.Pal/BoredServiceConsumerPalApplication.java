package cn.bored.service.consumer.Pal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description
 * @author: Ding
 * @create: 2019-07-03 18:34
 **/
@SpringBootApplication(scanBasePackages = "cn.bored.common")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.bored.common")
public class BoredServiceConsumerPalApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceConsumerPalApplication.class,args);
    }
}
