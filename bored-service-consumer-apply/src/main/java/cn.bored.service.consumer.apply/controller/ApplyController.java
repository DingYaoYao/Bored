package cn.bored.service.consumer.apply.controller;


import cn.bored.service.api.pal.PalService;
import cn.bored.common.dto.DtoResult;

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
public class ApplyController extends AbstractBaseController {

    @Autowired
    private ApplyService applyService;
    @Autowired
    private PalService palService;

    //查询带申请
    @GetMapping("/decided")
    DtoResult<Apply> getApplydDecided(HttpServletRequest request, HttpServletResponse response){
        User user = ConsumerConstant.getUser(request);
        List<Apply> applydDecided = applyService.getApplydDecided(user.getId());
        return  applydDecided==null?error():success(applydDecided);
    }

    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated")
    DtoResult<List<Apply>> getApplyDefeated(){
        User user = ConsumerConstant.getUser(request);
        List<Apply> applyDefeated = applyService.getApplyDefeated(user.getId());
        return  applyDefeated==null?error():success(applyDefeated);
    }


    /***添加好友请求
     * Ding
     * 一定注意申请人和被申请人不能申请两次   不然会在好友表出现两次，好友列表加载出来，申请列表加载出来全是一个人的
     * 中间要进女性判断两个人是否申请过
     */
    @PostMapping("/add")
    public DtoResult<Apply> add(Apply apply){
        User user = ConsumerConstant.getUser(request);
        apply.setFromUser(user.getId());
        DtoResult add = applyService.adds(apply);
          return templete(add);
    }
    /**同意添加好友
     *Ding
     * 当点击了同意  去操作Friends表  让两人成为好友后 在申请表中删除这条数据
     */
    @GetMapping("/consent/{to}")
    public DtoResult<Apply> del(@PathVariable long to){
        User user = ConsumerConstant.getUser(request);
        DtoResult friendsadd = palService.Friendsadd(user.getId(), to,"");
        //执行添加好友操作
        if(!isSuccess(friendsadd))return error("双向添加失败");

        //此操作会在好友同意添加为好友（节省数据库资源删除好友申请数据）
        DtoResult del = applyService.del(user.getId(), to);
        return templete(del);
    }
    //拒绝添加好友
    @GetMapping("/dowmApply/{id}")
    public DtoResult<Apply> update(@PathVariable  long id){
        User user = ConsumerConstant.getUser(request);
        DtoResult update = applyService.update(id);
        return templete(update);
    }
}
