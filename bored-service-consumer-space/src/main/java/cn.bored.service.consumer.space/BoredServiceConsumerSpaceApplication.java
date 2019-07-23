package cn.bored.service.consumer.space;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cn.bored"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.bored")
public class BoredServiceConsumerSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoredServiceConsumerSpaceApplication.class,args);
    }

}
