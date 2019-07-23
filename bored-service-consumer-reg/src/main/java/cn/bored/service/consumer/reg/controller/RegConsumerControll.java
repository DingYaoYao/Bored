package cn.bored.service.consumer.reg.controller;

import cn.bored.common.dto.DtoResult;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import cn.bored.service.consumer.reg.service.RegConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.AbstractCollection;

@RestController
@RequestMapping("/reg")
public class RegConsumerControll extends AbstractBaseController {

    @Autowired
    private RegConsumerService regConsumerService;

    @Value(value = "${server.port}")
    String port;
    @RequestMapping("/testt")
    public String test(HttpServletRequest httpServletRequest){
        String test = regConsumerService.test();
        System.out.println("----------------------------\n\n");
        return "结果等于===》"+test+port;
    }

    @PostMapping("/useradd")
    public DtoResult<Long> regz(User tbUser){
        DtoResult<User> regz = regConsumerService.regz(tbUser);
        if(StringUtils.isEmpty(regz)){
            return  error("网络异常请重试");
        }else if(StringUtils.isEmpty(regz.getData())){
            return  error(regz.getMessage());
        }else{
            return success(regz.getData().getId());
        }
    }
}
