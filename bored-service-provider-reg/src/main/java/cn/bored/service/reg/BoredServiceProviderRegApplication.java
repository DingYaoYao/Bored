package cn.bored.service.reg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "cn.bored")
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bored.mapper")
public class BoredServiceProviderRegApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceProviderRegApplication.class, args);
    }
}