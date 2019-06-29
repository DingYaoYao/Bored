package cn.bored.service.consumer.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.swing.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BoredServiceConsumerRegApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceConsumerRegApplication.class,args);
    }
}
