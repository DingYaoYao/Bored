package cn.bored.mapper;

import cn.bored.domain.Apply;
import mapper.MyMapper;

import java.util.List;

public interface ApplyMapper extends MyMapper<Apply> {
   //查询带申请
   List<Apply> getApplydDecided(long id);
   //查询被拒绝的，默认只查询五条
   List<Apply> getApplyDefeated(long id);

}
