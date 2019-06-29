package cn.bored.service.consumer.reg.controller;
import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.domain.User;
import cn.bored.service.consumer.reg.service.RegConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RegConsumerControll {

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

    @PostMapping("/ab")
    public AbstractBaseResult a(User tbUser){
        return regConsumerService.reg(tbUser);
    }
}
