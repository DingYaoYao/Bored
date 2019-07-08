package cn.bored.service.provider.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bored.common.mapper")
public class BoredServiceProviderFriendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceProviderFriendApplication.class,args);
    }
}
