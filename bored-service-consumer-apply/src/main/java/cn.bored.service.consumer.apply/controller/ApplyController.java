package cn.bored.service.consumer.apply.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Apply;
import cn.bored.domain.User;
import cn.bored.service.consumer.apply.consumer.ApplyConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
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
        apply.setFromUser(user.getId());
        String add = applyConsumerService.add(apply);
        return add==null?error("申请好友失败"):success();
    }
    @GetMapping("/del/{id}")
    public AbstractBaseResult del(@PathVariable long id){
        String del = applyConsumerService.del(id);
        //此操作会在好友同意添加为好友（节省数据库资源删除数据）
        return del==null?error("添加好友失败！"):success();
    }
    //拒绝添加好友
    @GetMapping("/update/{id}")
    public AbstractBaseResult update(@PathVariable  long id){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        String update = applyConsumerService.update(id);
        return update==null?error("拒绝好友失败！"):success();
    }
}
