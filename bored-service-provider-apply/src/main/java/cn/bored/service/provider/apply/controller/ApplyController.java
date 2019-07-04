package cn.bored.service.provider.apply.controller;

import cn.bored.domain.Apply;
import cn.bored.service.provider.apply.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 14:54
 **/
@RestController
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private ApplyService<Apply> applyService;

    //查询带申请
    @GetMapping("/decided/{id}")
    List<Apply> getApplydDecided(@PathVariable long id){
     return applyService.getApplydDecided(id);
    }
    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated/{id}")
    List<Apply> getApplyDefeated(@PathVariable long id){
     return applyService.getApplyDefeated(id);
    }

    @PostMapping("/add")
    public String add(Apply apply){
        apply.setApplyDate(new Date());
        int add = applyService.add(apply);
        System.out.println(add>0?"ok":null);
        return add>0?"ok":null;
    }
    @GetMapping("/del")
    public String del(long id){
        Apply apply = new Apply();
        apply.setId(id);
        int del = applyService.delByID(apply);
        return del>0?"ok":null;
    }
    //拒绝添加好友
    @GetMapping("/update")
    public String update(long id){
        Apply apply = new Apply();
        apply.setId(id);
        apply.setApplyDate(new Date());
        apply.setStatus(2);
        int update = applyService.updateByPrimaryKeySelective(apply);
        return update>0?"ok":null;
    }
}
