package cn.bored.common.utils;

import cn.bored.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-03 13:10
 **/

public class ConsumerConstant {

    public static String SESSION_USER ="USER";

    public static User getUser(HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(SESSION_USER);
        if(attribute instanceof  User){
            return (User)attribute;
        }
        return null;
    }
}
