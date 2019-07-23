package cn.bored.service.api.space;

import cn.bored.common.dto.DtoResult;

import cn.bored.domain.Topic;
import cn.bored.domain.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "bored-service-provider-space",fallback = SpaceServiceFallback.class)
public interface SpaceService {

    //匹配
    @PostMapping("/space/space")
    DtoResult<User> userSpace(@RequestBody Topic topic);

}
