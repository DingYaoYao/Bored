package cn.bored.service.reg.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.service.TbUserService;
import cn.bored.common.validator.BeanValidator;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import cn.bored.service.reg.service.RegService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reg")
public class RegController extends AbstractBaseController<User> {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private RegService regService;

    @PostMapping(value ="/useradd")
    public AbstractBaseResult reg(@RequestBody User tbUser) {
        // 数据校验
        String message = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(message)) {
            return error(message, null);
        }
        // 验手机号是否重复
        if (!tbUserService.unique("phone", tbUser.getPhone())) {
            return error("手机号重复，请重试", null);
        }
        //验证手机号验证码
        // 注册用户
        tbUser.setPicturepath("");
        tbUser.setToken("asdasdas");
        tbUser.setAccid("adad");
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
        User user = regService.save(tbUser);
        if (user != null) {
            user.setPassword("null");
            response.setStatus(HttpStatus.OK.value());
            return success(request.getRequestURI(), user);
        }
        // 注册失败
        return error("注册失败，请重试", null);
    }
}
