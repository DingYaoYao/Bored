package cn.bored.service.provider.apply.service;

import cn.bored.common.service.BaseService;
import cn.bored.domain.Apply;
import cn.bored.domain.BaseEntity;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 07:49
 **/
public interface ApplyService<T extends BaseEntity> extends BaseService<T> {

    //查询带申请
    List<Apply> getApplydDecided(long id);
    //查询被拒绝的，默认只查询五条
    List<Apply> getApplyDefeated(long id);
}
