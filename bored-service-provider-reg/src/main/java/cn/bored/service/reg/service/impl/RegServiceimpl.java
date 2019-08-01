package cn.bored.service.reg.service.impl;

import cn.bored.common.dto.AbstractBaseDomain;
import cn.bored.common.mapper.UserMapper;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.common.utils.ImServiceDTO;
import cn.bored.common.utils.RequestImService;
import cn.bored.domain.User;

import cn.bored.service.reg.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class RegServiceimpl extends BaseServiceImpl<User, UserMapper> implements RegService<User>{

    @Autowired
    private UserMapper userMapper;

    @Value("${reg.default.picturePath}")
    private String picturePath;
    @Value("${reg.default.backImg}")
    private String backImg;
    public User save(User domain) {
        int result = 0;
        Date currentDate = new Date();
        domain.setUpdate_date(currentDate);
        // 创建
        if (domain.getId() == null) {
            domain.setCreate_date(currentDate);
            String randomStr="";
            for (int i = 0; i < 9; i++) {
                int random=(int)(Math.random()*9);
                if(randomStr.indexOf(random+"")!=-1){
                    i=i-1;
                }else{
                    randomStr+=random;
                }
            }
            long b = Integer.parseInt(randomStr);
            domain.setId(b);
            domain.setPicturepath(picturePath);
            domain.setBackImg(backImg);
            ImServiceDTO accid = RequestImService.createACCID(domain.getNicename());
            if(accid==null){
                System.err.println("\n\n未能从网易云信获得用户标识！\n\n");
                return null;
            }
            domain.setAccid(accid.getInfo().getAccid());
            domain.setToken(accid.getInfo().getToken());
            /**
             * 用于自动回显 ID，领域模型中需要 @ID 注解的支持
             * {@link AbstractBaseDomain}
             */
            result = userMapper.insert(domain);
        }
        // 更新
        else {
            result = userMapper.updateByPrimaryKeySelective(domain);
        }
        // 保存数据成功
        if (result > 0) {
            return domain;
        }
        // 保存数据失败
        return null;
    }

}

