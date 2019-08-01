package cn.bored.service.api.pal;

import cn.bored.common.dto.DtoResult;
import cn.bored.domain.Friends;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-15 22:08
 **/
@Component
public class PalServiceFallback implements PalService {
    @Override
    public List<Friends> getFriendsdDecided(Long id) {
        return null;
    }

    @Override
    public DtoResult Friendsadd(Long id, Long Friendsid,String niceName ) {
        return null;
    }

    @Override
    public DtoResult Friendsdel(Long id, Long Friendsid) {
        return null;
    }
}
