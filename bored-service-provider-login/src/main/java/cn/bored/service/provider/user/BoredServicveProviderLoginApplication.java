package cn.bored.service.provider.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "cn.bored")
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bored.common.mapper")
public class BoredServicveProviderLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServicveProviderLoginApplication.class,args);

    }


}


