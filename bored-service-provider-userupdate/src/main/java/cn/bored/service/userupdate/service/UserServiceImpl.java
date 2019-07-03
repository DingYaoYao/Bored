package cn.bored.service.userupdate.service;

import cn.bored.common.dto.AbstractBaseDomain;
import cn.bored.common.service.impl.BaseServiceImpl;
import cn.bored.domain.User;
import cn.bored.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService<User>  {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByToken(String token) {
        return userMapper.getUserByToken(token);
    }

    @Override
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