package cn.bored.common.interceptor;



import cn.bored.common.service.RedisConsumerService;
import cn.bored.common.utils.ConsumerConstant;
import cn.bored.common.utils.JsonUtils;
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
    private RedisConsumerService redisConsumerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         //获得请求头保存的用户标识
        String token = request.getParameter("bored");
        HttpSession session = request.getSession();

        //标识不能为空
        if(!StringUtils.isEmpty(token)){
            String userString = redisConsumerService.get(token);
            User user=null;
            //判断缓存没有用户
            if(StringUtils.isEmpty(token)){
                user=null;
                //从数据库查询得到用户，
                 if(StringUtils.isEmpty(user)){
                     return false;
                 }
                session.setAttribute(ConsumerConstant.SESSION_USER,user);
                return true;
            }
            //缓存有值
            user = JsonUtils.jsonToPojo(userString, User.class);
            session.setAttribute(ConsumerConstant.SESSION_USER,user);
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}