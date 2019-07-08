package cn.bored.service.consumer.Pal.service;

import cn.bored.domain.Friends;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PalConsumerServiceimpl implements  PalConsumerService {
    @Override
    public List<Friends> GetuserPal(Long id) {
        return null;
    }

    @Override
    public int AddPAl(Long id, String Friendsid) {
        return 0;
    }

    @Override
    public int delPal(Long id, String Friendsid) {
        return 0;
    }
}
