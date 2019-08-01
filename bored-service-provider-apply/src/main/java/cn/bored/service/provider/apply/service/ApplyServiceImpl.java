package cn.bored.service.provider.apply.service;

import cn.bored.common.dto.DtoResult;

import cn.bored.common.mapper.ApplyMapper;


import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.Apply;
import cn.bored.service.api.apply.ApplyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 07:50
 **/
@RestController
public class ApplyServiceImpl extends BaseServiceImpl<Apply, ApplyMapper> implements ApplyService {


    @Autowired
    private ApplyMapper applyMapper;
    private final int STATUS=1;  //标识请求已发送
    private final int UNSTATUS=2;  //标识请求被拒绝

    //查询带申请
    @GetMapping("/decided/{id}")
    @Override
    public List<Apply> getApplydDecided(@PathVariable long id) {
        return applyMapper.getApplydDecided(id,STATUS);
    }

    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated/{id}")
    @Override
    public List<Apply> getApplyDefeated(@PathVariable long id) {
        return applyMapper.getApplyDefeated(id,UNSTATUS);
    }

    @PostMapping("/add")
    @Override
    public DtoResult adds(@RequestBody Apply apply) {
        //这是只是limit抽离出来一个，应删除多余的
        int count = applyMapper.findUserApplyCount(apply.getFromUser(), apply.getToUser(), 1);
        //执行修改用户状态,
        if (count > 0) {
            DtoResult update = update(count, STATUS);
            if(update!=null)return update;
            //执行添加用户请求
        } else {
            apply.setStatus(STATUS);
            int insert = applyMapper.add(apply);
            if (insert > 0) {
                return abstractBaseController.success();
            }
        }
        return abstractBaseController.error("操作失败");
    }


    @GetMapping("/del/{from}/{to}")
    @Override
    public DtoResult del(@PathVariable long from,@PathVariable long to) {
        int del = applyMapper.deleteByuserIdAndFriendId(from, to);
        if(del>0){
            return abstractBaseController.success();
        }else{
            //删除失败，但是数据库没有两个人的请求，也成功
            int userApplyCount = applyMapper.findUserApplyCount(from, to, STATUS);
            if(userApplyCount==0){
                return abstractBaseController.success();
            }
        }
        return abstractBaseController.error("操作失败！");
    }

    @GetMapping("/update/{applyId}")
    @Override
    public DtoResult update(@PathVariable long applyId) {
        DtoResult update = update(applyId, UNSTATUS);
        if(update!=null)return update;
        return abstractBaseController.error("操作失败！");
    }
    private DtoResult update(long id,int status){
        Apply apply = new Apply();
        apply.setId(id);
        apply.setStatus(status);
        apply.setApplyDate(new Date());
        int update = applyMapper.updateApplystatus(apply);
        if(update>0){
            return abstractBaseController.success();
        }
        return null;
    }


}
