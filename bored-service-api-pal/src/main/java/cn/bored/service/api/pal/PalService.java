package cn.bored.service.api.pal;



import cn.bored.common.dto.DtoResult;
import cn.bored.domain.Friends;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "bored-service-provider-Pal",fallback = PalServiceFallback.class)
public interface PalService  {

    //查询一个用户的好友
    @GetMapping("/Pal/GetuserPal/{id}")
    List<Friends> getFriendsdDecided(@PathVariable  Long id);
    //双向添加
    @PostMapping("/Pal/addPal")
    DtoResult Friendsadd(@RequestParam  Long id,@RequestParam  Long friendsId,@RequestParam String niceName );
    //双向删除
    @GetMapping("/Pal/delPal/{id}/{friendsId}")
    DtoResult Friendsdel(@PathVariable Long id,@PathVariable Long friendsId);
}
