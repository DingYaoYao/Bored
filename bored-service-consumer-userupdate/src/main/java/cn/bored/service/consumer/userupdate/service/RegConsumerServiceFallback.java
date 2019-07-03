package cn.bored.service.consumer.userupdate.service;


import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import org.springframework.stereotype.Component;

@Component
public class RegConsumerServiceFallback extends AbstractBaseController implements RegConsumerService{

    @Override
    public String update(User tbUser) {
       return "回滚";
    }
}
