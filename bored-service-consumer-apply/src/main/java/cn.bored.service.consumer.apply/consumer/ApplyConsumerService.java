package cn.bored.service.consumer.apply.consumer;

import cn.bored.domain.Apply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-04 09:59
 **/
@FeignClient(value = "bored-service-provider-apply",fallback = ApplyConsumerServiceImpl.class)
public interface ApplyConsumerService {

    //查询带申请
    @GetMapping("/apply/decided/{id}")
    List<Apply> getApplydDecided(@PathVariable long id);
    //查询被拒绝的，默认只查询五条
    @GetMapping("/apply/defeated/{id}")
    List<Apply> getApplyDefeated(@PathVariable long id);
    @PostMapping("/apply/add")
    public String add(@RequestBody  Apply apply);
    @GetMapping("/apply/del")
    public String del(@RequestParam  long id);
    //拒绝添加好友
    @GetMapping("/apply/update")
    public String update(@RequestParam long id);
}
