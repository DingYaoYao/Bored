package cn.bored.service.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bore.mapper")
public class BoredServicveProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoredServicveProviderUserApplication.class,args);
    }
}
