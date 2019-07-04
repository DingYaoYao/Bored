package cn.bored.service.consumer.apply.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Apply;
import cn.bored.domain.User;
import cn.bored.service.consumer.apply.consumer.ApplyConsumerService;
import cn.bored.service.provider.apply.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 14:54
 **/
@RestController
@RequestMapping("/apply")
public class ApplyController extends AbstractBaseController<Apply> {

    @Autowired
    private ApplyConsumerService applyConsumerService;

    //查询带申请
    @GetMapping("/decided")
    AbstractBaseResult getApplydDecided(HttpServletRequest request){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        List<Apply> applydDecided = applyConsumerService.getApplydDecided(user.getId());
        return  applydDecided==null?sentinelError():success(applydDecided);
    }
    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated")
    AbstractBaseResult getApplyDefeated(){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        List<Apply> applyDefeated = applyConsumerService.getApplyDefeated(user.getId());
        return  applyDefeated==null?sentinelError():success(applyDefeated);
    }

    @PostMapping("/add")
    public AbstractBaseResult add(Apply apply){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        String add = applyConsumerService.add(apply);
        return add==null?error("操作失败"):success();
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
