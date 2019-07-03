package cn.bored.common.config;



import cn.bored.common.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 08:50
 **/
@Configuration
public class TokenConfig implements WebMvcConfigurer {


    @Bean
    TokenInterceptor TokenInterceptor(){
        return new TokenInterceptor();
    }

    //添加拦截器，不拦截登陆注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(TokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","reg/useradd");
    }

}
