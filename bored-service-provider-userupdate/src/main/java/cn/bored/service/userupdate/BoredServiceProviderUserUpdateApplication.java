package cn.bored.service.userupdate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"cn.bored.service.userupdate","cn.bored.common"})
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.bored.common.mapper")
public class BoredServiceProviderUserUpdateApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoredServiceProviderUserUpdateApplication.class, args);
    }
}
