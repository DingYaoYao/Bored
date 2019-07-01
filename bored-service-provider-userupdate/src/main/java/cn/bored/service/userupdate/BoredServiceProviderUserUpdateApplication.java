package cn.bored.service.userupdate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "cn.bored")
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bored.mapper")
public class BoredServiceProviderUserUpdateApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceProviderUserUpdateApplication.class, args);
    }
}