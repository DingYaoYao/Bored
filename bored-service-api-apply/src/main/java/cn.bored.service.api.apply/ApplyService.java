package cn.bored.service.api.apply;

import cn.bored.common.dto.DtoResult;
import cn.bored.domain.Apply;
import cn.bored.service.api.apply.ApplyServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-04 09:59
 **/
@FeignClient(value = "bored-service-provider-apply",fallback = ApplyServiceFallback.class)
public interface ApplyService {

    //查询带申请
    @GetMapping("/decided/{id}")
    List<Apply> getApplydDecided(@PathVariable long id);

    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated/{id}")
    List<Apply> getApplyDefeated(@PathVariable long id);

    //添加用户请求
    @PostMapping("/add")
    DtoResult adds(@RequestBody  Apply apply);

    //删除用户请求,同意添加好友是调用
    @GetMapping("/del/{from}/{to}")
    DtoResult del(@PathVariable  long from,@PathVariable long to);

    //拒绝用户请求
    @GetMapping("/update/{applyId}")
    DtoResult update(@PathVariable long applyId);
}
