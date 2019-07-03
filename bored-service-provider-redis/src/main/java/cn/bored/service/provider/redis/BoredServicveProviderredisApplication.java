package cn.bored.service.provider.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 11:27
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class BoredServicveProviderredisApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServicveProviderredisApplication.class,args);
    }
}
