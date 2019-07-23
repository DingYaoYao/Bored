package cn.bored.service.api.friend;

import cn.bored.common.dto.DtoResult;
import cn.bored.domain.Friend;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "bored-service-provider-friend",fallback =friendServiceFallback.class )
public interface friendService {

    @GetMapping(value = "/friend/myfriend/{userId}")
     List<Friend> myfriend(@PathVariable long userId);

    @GetMapping(value = "/friend/myfriendFriends/{userId}")
     List<Friend> myfriendFriends(@PathVariable long userId);

    @PostMapping(value = "/friend/add")
    DtoResult addFriend(@RequestBody Friend friend);

    @GetMapping(value = "/friend/del/{id}")
    DtoResult del(@PathVariable int id);

    @GetMapping(value = "/friend/updatelike/{id}")
    DtoResult updatelike(@PathVariable long id);
}
