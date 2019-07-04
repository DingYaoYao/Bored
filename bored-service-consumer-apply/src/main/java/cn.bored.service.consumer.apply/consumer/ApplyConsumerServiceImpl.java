package cn.bored.service.consumer.apply.consumer;

import cn.bored.domain.Apply;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-04 10:03
 **/
@Component
public class ApplyConsumerServiceImpl implements ApplyConsumerService {
    @Override
    public List<Apply> getApplydDecided(long id) {
        return null;
    }

    @Override
    public List<Apply> getApplyDefeated(long id) {
        return null;
    }

    @Override
    public String add(Apply apply) {
        return null;
    }

    @Override
    public String del(long id) {
        return null;
    }

    @Override
    public String update(long id) {
        return null;
    }
}
