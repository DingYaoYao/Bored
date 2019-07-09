package cn.bored.service.provider.apply.service;

import cn.bored.common.context.ApplicationContextHolder;
import cn.bored.common.mapper.ApplyMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.Apply;


import cn.bored.service.api.apply.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

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
    @Autowired
    private ApplicationContextHolder applicationContextHolder;

    //查询带申请
    @GetMapping("/decided/{id}")
    @Override
   public  List<Apply> getApplydDecided(@PathVariable long id){
        return applyMapper.getApplydDecided(id);
    }
    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated/{id}")
    @Override
    public List<Apply> getApplyDefeated(@PathVariable long id){
        return applyMapper.getApplyDefeated(id);
    }

    @PostMapping("/add")
    public Integer adds(@RequestBody Apply apply){
        apply.setApplyDate(new Date());
        apply.setStatus(1);
        int add = applyMapper.insert(apply);
        return add>0?0:null;
    }
    @GetMapping("/del")
    public Integer del(long id){
        Apply apply = new Apply();
        apply.setId(id);
        int del = applyMapper.deleteByPrimaryKey(apply);
        return del>0?0:null;
    }
    //拒绝添加好友
    @GetMapping("/update")
    public Integer update(long id){
        Apply apply = new Apply();
        apply.setId(id);
        apply.setApplyDate(new Date());
        apply.setStatus(2);
        int update = applyMapper.updateByPrimaryKeySelective(apply);
        return update>0?0:null;
    }}
