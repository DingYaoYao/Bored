package cn.bored.service.userupdate.service;

import cn.bored.common.service.BaseCrudService;
import cn.bored.common.validator.BeanValidator;
import cn.bored.service.api.user.UserService;

import cn.bored.common.dto.DtoResult;
import cn.bored.common.mapper.UserMapper;
import cn.bored.common.service.impl.BaseServiceImpl;

import cn.bored.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/user")
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
     private  BaseCrudService baseCrudService;


    @GetMapping("/token/{token}")
    @Override
    public DtoResult<User> getUserByToken(@PathVariable  String token) {
      return getUser(token,null);
    }

    @Override
    @GetMapping("/id/{id}")
    public  DtoResult<User> getUserById(@PathVariable long id){
        return getUser(null,id);
    }
    private DtoResult<User> getUser(String token,Long id){
        User user = userMapper.getUserByTokenOrId(token,id);
        if(StringUtils.isEmpty(user)){
            return abstractBaseController.error("用户不存在！");
        }
        return abstractBaseController.success(user);
    }





}
