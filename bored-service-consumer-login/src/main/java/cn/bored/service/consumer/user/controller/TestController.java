package cn.bored.service.consumer.user.controller;

import cn.bored.service.consumer.user.consumer.UserConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-28 17:54
 **/
@RestController
public class TestController {

    @Autowired
    private UserConsumerService userConsumerService;

    @Value(value = "${server.port}")
    String port;

    @RequestMapping("/testconsumer")
    public String test(HttpServletRequest httpServletRequest){
        String test = userConsumerService.test();
        HttpSession session = httpServletRequest.getSession();
        Object sesssionValue = session.getAttribute("test");

        System.out.println("进入方法------------");
        System.out.println("获得session---------"+session);
        System.out.println("获得回话值----------"+sesssionValue);
        if(StringUtils.isEmpty(sesssionValue)){
            System.out.println("回话值等于null--"+port);
            session.setAttribute("test",port);
        }
        System.out.println("----------------------------\n\n");
        return "结果等于===》"+test+port;
    }
}
