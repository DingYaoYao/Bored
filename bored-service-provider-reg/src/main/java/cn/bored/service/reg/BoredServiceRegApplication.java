package cn.bored.service.reg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(scanBasePackages = "cn.bored")
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bore.mapper")
public class BoredServiceRegApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceRegApplication.class, args);
    }
}