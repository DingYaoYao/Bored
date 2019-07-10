package cn.bored.service.consumer.Pal.service;

import cn.bored.domain.Friends;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description
 * @author: Ding
 * @create: 2019-07-04 09:59
 **/
@FeignClient(value = "bored-service-provider-Pal",fallback = PalConsumerServiceimpl.class)
public interface PalConsumerService {

    @GetMapping("Pal/GetuserPal/{id}")
    public List<Friends> GetuserPal(@PathVariable  Long id);
    @PostMapping("Pal/addPal")
    public int AddPAl(@RequestParam Long id,@RequestParam Long Friendsid);
    @PostMapping("Pal/delPal")
    public int delPal(@RequestParam Long id,@RequestParam Long Friendsid);

}
