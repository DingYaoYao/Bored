package cn.bored.common.interceptor;

import cn.bored.service.api.user.UserService;
import cn.bored.api.redis.RedisService;
import cn.bored.common.dto.DtoResult;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.utils.JsonUtils;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * token 验证
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
private AbstractBaseController abstractBaseController;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获得请求头保存的用户标识
        String token = request.getHeader("bored");
        HttpSession session = request.getSession();
        boolean flag = false;

        //标识不能为空
        if (!StringUtils.isEmpty(token)) {
            String userString = redisService.get(token);
            User user = null;
            //判断缓存没有用户
            if (StringUtils.isEmpty(userString)) {
                DtoResult<User> userByToken = userService.getUserByToken(token);
                if(abstractBaseController.isSuccess(userByToken)){
                    user=userByToken.getData();
                    //数据库存在
                    if (!StringUtils.isEmpty(user)) {
                        redisService.set2(token, JsonUtils.objectToJson(user));
                        session.setAttribute(ConsumerConstant.SESSION_USER, user);
                        flag = true;
                    }
                }
                //缓存有值
            } else {
                user = JsonUtils.jsonToPojo(userString, User.class);
                session.setAttribute(ConsumerConstant.SESSION_USER, user);
                flag = true;
            }

        }
        //标识为空
        if(!flag){
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JsonUtils.objectToJson(abstractBaseController.userError()));
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
