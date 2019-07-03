package cn.bored.service.provider.apply.service;

import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.Apply;
import cn.bored.mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 07:50
 **/
@Service
public class ApplyServiceImpl extends BaseServiceImpl<Apply, ApplyMapper> implements  ApplyService<Apply>  {

    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public List<Apply> getApplydDecided(String id) {
        return applyMapper.getApplydDecided(id);
    }

    @Override
    public List<Apply> getApplyDefeated(String id) {
        return applyMapper.getApplyDefeated(id);
    }
}
