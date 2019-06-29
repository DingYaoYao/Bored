package cn.bored.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-28 16:04
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BoredGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredGatewayApplication.class,args);
    }
}
