package cn.bored.service.consumer.reg.service;


import cn.bored.common.dto.DtoResult;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import org.springframework.stereotype.Component;

@Component
public class RegConsumerServiceFallback extends AbstractBaseController implements RegConsumerService{
    @Override
    public String test() {
        return "这是触发回滚";
    }

    @Override
    public DtoResult<User> regz(User tbUser) {
       return null;
    }
}
