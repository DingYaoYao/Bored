package cn.bored.service.provider.pal.service;

import cn.bored.service.api.pal.PalService;
import cn.bored.common.dto.DtoResult;
import cn.bored.common.mapper.FriendsMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Service
@RequestMapping("/Pal")
public class PalServiceimpl extends BaseServiceImpl<Friends, FriendsMapper> implements PalService {

    @Autowired
    private FriendsMapper friendsMapper;

    @Override
    @GetMapping("/GetuserPal/{id}")
    public List<Friends> getFriendsdDecided(@PathVariable  Long id) {
        return friendsMapper.getFriendsDecided(id);
    }

    @Override
    @PostMapping("/addPal")
    public DtoResult Friendsadd(@RequestParam Long id,@RequestParam  Long friendsId,String niceName ) {

        Friends friends = new Friends();
        friends.setUserid(id);
        friends.setFriendUserId(String.valueOf(friendsId));
        int resut = friendsMapper.add(friends);

        //只有别人才设置了备注，还有一种情况（详情页添加时两个人都有，暂不处理），
        Friends friendsa = new Friends();
        friendsa.setUserid(friendsId);
        friendsa.setFriendNicename(niceName);
        friendsa.setFriendUserId(String.valueOf(id));
        int resuat = friendsMapper.add(friendsa);

        int a = resut + resuat;
        if(a>=2){
            return abstractBaseController.success();
        }
        return abstractBaseController.error("添加用户失败！");
    }

    @Override
    @GetMapping("/delPal/{id}/{friendsId}")
    public DtoResult Friendsdel(@PathVariable Long id, @PathVariable Long friendsId) {
        int resoulta = friendsMapper.Friendsdel(friendsId, id);
        int resoultb = friendsMapper.Friendsdel(id, friendsId);
        int a = resoulta + resoultb;
        if(a>=2){
            return abstractBaseController.success();
        }
        return abstractBaseController.error("删除用户失败！");
    }
}
