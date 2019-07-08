package cn.bored.service.api.apply;

import cn.bored.domain.Apply;


import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-04 10:03
 **/
@Component
public class ApplyServiceFallback implements ApplyService {
    @Override
    public List<Apply> getApplydDecided(long id) {
        return null;
    }

    @Override
    public List<Apply> getApplyDefeated(long id) {
        return null;
    }

    @Override
    public Integer adds(Apply apply) {
        return null;
    }

    @Override
    public Integer del(long id) {
        return null;
    }

    @Override
    public Integer update(long id) {
        return null;
    }
}
