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

    @GetMapping("/GetuserPal/{id}")
    public List<Friends> GetuserPal( Long id);
    @PostMapping("/addPal")
    public int AddPAl(@RequestParam Long id, String Friendsid);
    @PostMapping("/delPal")
    public int delPal(@RequestParam Long id,String Friendsid);

}
