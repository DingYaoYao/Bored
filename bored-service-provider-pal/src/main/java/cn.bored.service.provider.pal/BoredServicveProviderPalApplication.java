package cn.bored.service.provider.pal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description
 * @author: Ding
 * @create: 2019-07-03 07:44
 **/
@SpringBootApplication
@MapperScan("cn.bored.common.mapper")
@EnableDiscoveryClient
public class BoredServicveProviderPalApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServicveProviderPalApplication.class,args);
    }
}
