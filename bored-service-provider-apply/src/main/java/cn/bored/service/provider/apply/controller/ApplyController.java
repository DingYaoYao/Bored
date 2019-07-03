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
    List<Apply> getApplydDecided(@PathVariable String id){
     return applyService.getApplydDecided(id);
    }
    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated/{id}")
    List<Apply> getApplyDefeated(@PathVariable String id){
     return applyService.getApplyDefeated(id);
    }

    @PostMapping("/add")
    public String add(Apply apply){
        apply.setCreate_date(new Date());
        int add = applyService.add(apply);
        return add>1?"ok":null;
    }
    @GetMapping("/del")
    public String del(Apply applyid){
        int del = applyService.delByID(applyid);
        return del>1?"ok":null;
    }
    @GetMapping("/update")
    public String update(Apply applyid){
        applyid.setApplyDate(new Date());
        int update = applyService.updateByPrimaryKeySelective(applyid);
        return update>1?"ok":null;
    }
}
