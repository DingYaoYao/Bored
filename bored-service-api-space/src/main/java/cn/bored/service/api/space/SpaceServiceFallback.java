package cn.bored.service.api.space;

import cn.bored.common.dto.DtoResult;
import cn.bored.domain.Topic;
import cn.bored.domain.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-18 22:45
 **/
@Component
public class SpaceServiceFallback implements SpaceService {
    @Override
    public DtoResult<User> userSpace(Topic topic) {
        return null;
    }
}
