package cn.bored.service.consumer.login;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"cn.bored"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.bored")
public class BoredServiceConsumerLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceConsumerLoginApplication.class,args);
    }


}
