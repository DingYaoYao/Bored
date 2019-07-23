package cn.bored.service.userupdate.service;
import cn.bored.common.dto.AbstractBaseDomain;
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
    private BaseCrudService baseCrudService;

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

    /***
     * 用户传入一个完成user对象
     * @param tbUser
     * @return
     */
    @PostMapping(value ="/update")
    public   DtoResult<User> update(@RequestBody User tbUser) {
        //查询token是否是这个user的

        // 数据校验
        String message = BeanValidator.validator(tbUser);
        if (!StringUtils.isEmpty(message)) {
            return abstractBaseController.error("数据验证失败");
        }
        // 验证手机号是否和其他的重复
        User usera= new User();
        usera.setId(tbUser.getId());

        try{
            User userl=userMapper.selectByPrimaryKey(usera);
            if (!baseCrudService.unique("phone", tbUser.getPhone())) {
                if(userl.getPhone().equals(tbUser.getPhone())){
                    return userupdate(tbUser,userl);
                }
                return abstractBaseController.error("手机号重复，请重试", null);
            }else{
                //执行修改了手机号并且通过了数据库中的重复验证之后进行修改
                return  userupdate(tbUser,userl);
            }
        }catch (Exception e){
            return abstractBaseController.error("修改失败，请重试", null);
        }
    }


    /***
     * 内部方法
     * @param tbUser
     * @param userl
     * @return
     */
    public DtoResult<User> userupdate(User tbUser, User userl){

        //验证手机号验证码
        // 执行未修改手机号的修改的操作
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
        tbUser.setCreate_date(userl.getCreate_date());
        try{
            User user = save(tbUser);
            if (user != null) {
                user.setPassword("null");
                return abstractBaseController.success(user);
        }
        }catch (Exception e){
            System.out.print(e.getMessage());
            return abstractBaseController.error("修改失败，请重试", null);
        }
        return abstractBaseController.error("修改失败，请重试", null);
    }
}
