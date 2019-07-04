package cn.bored.service.consumer.apply.consumer;

import cn.bored.domain.Apply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-04 09:59
 **/
@FeignClient(value = "bored-service-provider-apply",fallback = ApplyConsumerServiceImpl.class)
public interface ApplyConsumerService {

    //查询带申请
    @GetMapping("/decided/{id}")
    List<Apply> getApplydDecided(@PathVariable long id);
    //查询被拒绝的，默认只查询五条
    @GetMapping("/defeated/{id}")
    List<Apply> getApplyDefeated(@PathVariable long id);
    @PostMapping("/add")
    public String add(@RequestBody  Apply apply);
    @GetMapping("/del")
    public String del(@RequestParam  long id);
    //拒绝添加好友
    @GetMapping("/update")
    public String update(@RequestParam long id);
}
