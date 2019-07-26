package cn.bored.gateway.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 鉴权过滤器
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Autowired
    ExcludePath excludePath;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        RequestPath path = request.getPath();

        if(!excludePath.getPaths().contains(uri.getPath())){
            System.out.println(uri.getPath()+"===>当前路径没有被排除");
            HttpHeaders headers = request.getHeaders();
            List<String> token = headers.get("bored");

            if (token == null || token.isEmpty()) {
                ServerHttpResponse response = exchange.getResponse();

                // 封装错误信息
                Map<String, Object> responseData = Maps.newHashMap();
                responseData.put("code", 201);
                responseData.put("message", "gateway用户没登陆！");
                // responseData.put("cause", "Token is empty");

                try {
                    // 将信息转换为 JSON
                    ObjectMapper objectMapper = new ObjectMapper();
                    byte[] data = objectMapper.writeValueAsBytes(responseData);

                    // 输出错误信息到页面
                    DataBuffer buffer = response.bufferFactory().wrap(data);
                    response.setStatusCode(HttpStatus.CREATED);
                    response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                    return response.writeWith(Mono.just(buffer));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("排除路径===》"+uri.getPath());
        }

        return chain.filter(exchange);
    }

    /**
     * 设置过滤器的执行顺序
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
