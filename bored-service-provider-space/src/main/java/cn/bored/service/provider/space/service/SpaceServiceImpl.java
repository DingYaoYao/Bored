package cn.bored.service.provider.space.service;

import cn.bored.common.dto.DtoResult;
import cn.bored.common.mapper.SpaceMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.Space;
import cn.bored.domain.Topic;
import cn.bored.domain.User;
import cn.bored.service.api.space.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/space")
@Service
public class SpaceServiceImpl extends BaseServiceImpl<Space, SpaceMapper> implements SpaceService {


    @Autowired
    private SpaceMapper spaceMapper;

    @Override
    @PostMapping(value = "/space")
    public DtoResult<User> userSpace(@RequestBody Topic topic){
        Long titleid = null;
        Long id = topic.getUserid();

        Topic Stopic = spaceMapper.selectTopic(topic);

        if(Stopic != null){
            titleid = Stopic.getId();
            User spaceuser = spaceMapper.userspace(id ,titleid);
            return abstractBaseController.success(spaceuser);
        }else{
            int rr = spaceMapper.insertTopic(topic);
            if(rr >= 1){
                int resullt1 = spaceMapper.insertSpace(topic);
                if(resullt1 >= 1){
                    return abstractBaseController.success();
                }
            }
        }
        return abstractBaseController.error("执行添加失败！");
    }
}
