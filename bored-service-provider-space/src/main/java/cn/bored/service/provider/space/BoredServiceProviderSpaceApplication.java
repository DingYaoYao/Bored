package cn.bored.service.provider.space;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "cn.bored")
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bored.common.mapper")
public class BoredServiceProviderSpaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceProviderSpaceApplication.class,args);

    }

}
