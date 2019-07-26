package cn.bored.gateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-25 22:33
 **/
@Component
@Configuration
@ConfigurationProperties(prefix = "exclude-paths-list") // 不同的配置类，其前缀不能相同
@EnableConfigurationProperties(ExcludePath.class) // 必须标明这个类是允许配置的
public class ExcludePath {

    //要排除的路径
    private  List<String> paths=new ArrayList<String>();

    public  List<String> getPaths() {
        return paths;
    }

    public  void setPaths(List<String> paths) {
       this.paths = paths;
    }
}
