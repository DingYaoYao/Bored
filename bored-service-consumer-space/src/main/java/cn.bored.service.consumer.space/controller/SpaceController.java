package cn.bored.service.consumer.space.controller;

import cn.bored.common.dto.DtoResult;

import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.Topic;
import cn.bored.domain.User;

import cn.bored.service.api.space.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/space")
public class SpaceController extends AbstractBaseController<User> {


    @Autowired
    private SpaceService spaceService;

    @PostMapping(value = "/space")
    public DtoResult UserSpace(Topic topic, HttpServletRequest request) {
        User user = ConsumerConstant.getUser(request);
        topic.setUserid(user.getId());
        DtoResult userspace = spaceService.userSpace(topic);
        return templete(userspace);
    }
}
