package cn.bored.service.userupdate.controller;

import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.service.TbUserService;
import cn.bored.common.validator.BeanValidator;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import cn.bored.mapper.UserMapper;
import cn.bored.service.userupdate.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractBaseController<User> {

    @Autowired
   private TbUserService tbUserService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService<User> userService;

    @GetMapping("/getUserByToken")
    public User getUserByToken(String token){
        return userService.getUserByToken(token);
    }

    /***
     * 用户传入一个完成user对象  返回0和1标识成功失败
     * @param tbUser
     * @return
     */
    @PostMapping(value ="/update")
    public AbstractBaseResult reg(@RequestBody User tbUser) {
        //查询token是否是这个user的
        // 数据校验
        String message = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(message)) {
            return error(message, null);
        }
        // 验证手机号是否和其他的重复
        User usera= new User();
        usera.setId(tbUser.getId());
<<<<<<< HEAD:bored-service-provider-userupdate/src/main/java/cn/bored/service/userupdate/controller/RegController.java

        try{
            User userl=userMapper.selectByPrimaryKey(usera);
            if (!tbUserService.unique("phone", tbUser.getPhone())) {
                if(userl.getPhone().equals(tbUser.getPhone())){
                    return userupdate(tbUser,userl);
                }
                return error("手机号重复，请重试", null);
            }else{
                //执行修改了手机号并且通过了数据库中的重复验证之后进行修改
                return  userupdate(tbUser,userl);
            }
        }catch (Exception e){
            return error("修改失败，请重试", null);
=======
        User userl=userMapper.selectByPrimaryKey(usera);
        if (!tbUserService.unique("phone", tbUser.getPhone())) {
            if(userl.getPhone().equals(tbUser.getPhone())){
                return userupdate(tbUser,userl);
            }
            return error("手机号重复，请重试", null);
        }else{
            //执行修改了手机号并且通过了数据库中的重复验证之后进行修改
            return  userupdate(tbUser,userl);
>>>>>>> 5dc9446b9cfcdce0b121cac6fdcbc0171f2c8b3f:bored-service-provider-userupdate/src/main/java/cn/bored/service/userupdate/controller/UserController.java
        }
    }

        // 根据用户得id查询用户得信息
    @GetMapping(value = "getid")



    /***
     * 内部方法
     * @param tbUser
     * @param userl
     * @return
     */
    public AbstractBaseResult userupdate(User tbUser,User userl){

        //验证手机号验证码
        // 执行未修改手机号的修改的操作
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
        tbUser.setCreate_date(userl.getCreate_date());
        try{
            User user = tbUserService.save(tbUser);
            if (user != null) {
                user.setPassword("null");
                response.setStatus(HttpStatus.OK.value());
                return success(request.getRequestURI(), user);
            }
        }catch (Exception e){
            System.out.print(     e.getMessage());
            return error("修改失败，请重试", null);
        }
        return error("修改失败，请重试", null);
    }

}
