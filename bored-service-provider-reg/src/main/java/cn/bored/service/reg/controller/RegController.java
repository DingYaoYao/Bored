package cn.bored.service.reg.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.service.TbUserService;
import cn.bored.common.validator.BeanValidator;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "reg")
public class RegController extends AbstractBaseController<User> {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping(value = "")
    public AbstractBaseResult reg(User tbUser) {
        // 数据校验
        String message = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(message)) {
            return error(message, null);
        }


        // 验证邮箱是否重复
        if (!tbUserService.unique("email", tbUser.getEmail())) {
            return error("邮箱重复，请重试", null);
        }

        // 注册用户
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
        TbUser user = tbUserService.save(tbUser);
        if (user != null) {
            response.setStatus(HttpStatus.CREATED.value());
            return success(request.getRequestURI(), user);
        }

        // 注册失败
        return error("注册失败，请重试", null);
    }
}