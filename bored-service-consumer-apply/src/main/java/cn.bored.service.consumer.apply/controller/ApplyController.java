package cn.bored.service.consumer.apply.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Apply;
import cn.bored.domain.User;
import cn.bored.service.api.apply.ApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ApplyService applyService;

    //查询带申请
    @GetMapping("/decided")
    AbstractBaseResult getApplydDecided(HttpServletRequest request, HttpServletResponse response){


        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        List<Apply> applydDecided = applyService.getApplydDecided(user.getId());
        return  applydDecided==null?sentinelError():success(applydDecided);
    }

    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated")
    AbstractBaseResult getApplyDefeated(){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        List<Apply> applyDefeated = applyService.getApplyDefeated(user.getId());
        return  applyDefeated==null?sentinelError():success(applyDefeated);
    }

    @PostMapping("/add")
    public AbstractBaseResult add(Apply apply){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        apply.setFromUser(user.getId());
        /***
         *
         *
         * Ding
         * s
         *select touser-di from apply where from-User=1  and status=1 and to-dromuser=2
         * 一定注意申请人和被申请人不能申请两次   不然会在好友表出现两次，好友列表加载出来，申请列表加载出来全是一个人的
         * 中间要进女性判断两个人是否申请过
         *
         *
         *
         *
         *
         */
        Integer add = applyService.adds(apply);
        return add==null?error("申请好友失败"):success();
    }
    @GetMapping("/del/{id}")
    public AbstractBaseResult del(@PathVariable long id){
        Integer del = applyService.del(id);

        /****
         *
         *
         *
         *
         *Ding
         *
         * 当点击了同意  去操作Friends表  让两人成为好友后 在申请表中删除这条数据
         *
         *
         *
         *
         *
         */
        //此操作会在好友同意添加为好友（节省数据库资源删除数据）
        return del==null?error("添加好友失败！"):success();
    }
    //拒绝添加好友
    @GetMapping("/update/{id}")
    public AbstractBaseResult update(@PathVariable  long id){
        User user = ConsumerConstant.getUser(request);
        if(user==null)return userError();
        Integer update = applyService.update(id);
        return update==null?error("拒绝好友失败！"):success();
    }
}
