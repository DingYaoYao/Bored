package cn.bored.service.consumer.userupdate.controller;
import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.domain.User;
import cn.bored.service.consumer.userupdate.service.RegConsumerService;
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

    @PostMapping("/update")
    public String update(User tbUser){
        return regConsumerService.update(tbUser);
    }
}
