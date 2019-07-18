package cn.bored.service.api.apply;

import cn.bored.common.dto.DtoResult;
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
    public DtoResult adds(Apply apply) {
        return null;
    }

    @Override
    public DtoResult del(long from, long to) {
        return null;
    }

    @Override
    public DtoResult update(long id) {
        return null;
    }
}
