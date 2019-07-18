package cn.bored.common.mapper;

import cn.bored.common.utils.RedisCache;
import cn.bored.domain.Apply;
import mapper.MyMapper;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface ApplyMapper extends MyMapper<Apply> {
   //查询带申请
   List<Apply> getApplydDecided(long from,int status);
   //查询被拒绝的，默认只查询五条
   List<Apply> getApplyDefeated(long from,int status);
    //查询用户和指定用户的好友请求数量
   int findUserApplyCount(long from ,long to,int status);
   //修改请求状态
   int updateApplystatus(long id,int status);
     //删除用户请求
   int deleteByuserIdAndFriendId(long from ,long to);

}
