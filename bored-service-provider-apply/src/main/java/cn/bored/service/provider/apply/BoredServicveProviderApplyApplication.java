package cn.bored.service.provider.apply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 07:44
 **/
@SpringBootApplication
@MapperScan("cn.bored.common.mapper")
@EnableDiscoveryClient
public class BoredServicveProviderApplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoredServicveProviderApplyApplication.class,args);
    }
}
