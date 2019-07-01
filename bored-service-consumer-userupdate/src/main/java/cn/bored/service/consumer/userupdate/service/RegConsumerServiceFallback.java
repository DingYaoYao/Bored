package cn.bored.service.consumer.userupdate.service;

import cn.bored.common.dto.AbstractBaseResult;
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
    public AbstractBaseResult regz(User tbUser) {
       return error("注册失败，请重试", null);
    }
}
