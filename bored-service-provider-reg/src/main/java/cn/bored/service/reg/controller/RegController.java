package cn.bored.service.reg.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.service.TbUserService;
import cn.bored.common.utils.ImServiceDTO;
import cn.bored.common.utils.RequestImService;
import cn.bored.common.validator.BeanValidator;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reg")
public class RegController extends AbstractBaseController<User> {

    @Autowired
    private TbUserService tbUserService;
    @GetMapping("/test")
    public String sd(){
    return "啊啊撒";
    }

    @PostMapping(value ="/useradd")
    public AbstractBaseResult reg(@RequestBody User tbUser) {
        // 数据校验
        String message = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(message)) {
            //现在返回的是200  以前是401
            return error(message, null);
        }
        // 验证邮箱是否重复
        if (!tbUserService.unique("phone", tbUser.getPhone())) {
            return error("手机号重复，请重试", null);
        }
        //验证手机号验证码


        // 注册用户
        tbUser.setPicturepath("默认路径");
       // ImServiceDTO accid = RequestImService.createACCID(tbUser.getNicename());
//        tbUser.setAccid(accid.getInfo().getAccid());
//        tbUser.setToken(accid.getInfo().getToken());
        tbUser.setAccid("dfgd");
        tbUser.setToken("gfh");
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
       try {
           User user = tbUserService.save(tbUser);
           if (user != null) {
               //现在返回的是 200  以前是201
               user.setPassword("null");
               response.setStatus(HttpStatus.OK.value());
               return success(request.getRequestURI(), user);
           }
       }catch (Exception e){
           return error("注册失败，请重试", null);
       }
        // 注册失败
        return error("注册失败，请重试", null);
    }
}