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
@SpringBootApplication(scanBasePackages = "cn.bored")
@MapperScan(basePackages = {"cn.bored.common.mapper"})
@EnableDiscoveryClient
public class BoredServiceProviderApplyApplication {

    public static void main(String[] args) {
       SpringApplication.run(BoredServiceProviderApplyApplication.class,args);

    }
}
