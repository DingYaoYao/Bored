package cn.bored.common.web;

import cn.bored.common.dto.AbstractBaseDomain;
import cn.bored.common.dto.AbstractBaseResult;
import cn.bored.common.dto.BaseResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通用的控制器
 * <p>Title: AbstractBaseController</p>
 * <p>Description: </p>
 *
 * @author Ding
 * @version 1.0.0
 * @date 2019/1/25 11:11
 */
public abstract class AbstractBaseController<T extends AbstractBaseDomain> {

    // 用于动态获取配置文件的属性值
    private static final String ENVIRONMENT_LOGGING_LEVEL_MY_SHOP = "日志文件的路径在哪里？？？";

    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @ModelAttribute
    public void initReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 请求成功
     * @param self
     * @param attribute
     * @return
     */
    protected AbstractBaseResult success(String self, T attribute) {
        return BaseResultFactory.getInstance(response).build(self, attribute);
    }

    /**
     * 请求成功
     * @param self
     * @param next
     * @param last
     * @param attributes
     * @return
     */
    protected AbstractBaseResult success(String self, int next, int last, List<T> attributes) {
        return BaseResultFactory.getInstance(response).build(self, next, last, attributes);
    }
    //用户只返回集合
    protected AbstractBaseResult success(List<T> attributes) {
        return BaseResultFactory.getInstance(response).build("", 0, 0, attributes);
    }
    //成功只返回状态
    protected AbstractBaseResult success() {
        return BaseResultFactory.getInstance(response).build();
    }
    /**
     * 请求失败
     * @param title
     * @param detail
     * @return
     */
    protected AbstractBaseResult error(String title, String detail) {
        // return error(HttpStatus.UNAUTHORIZED.value(), title, detail);
       return error(HttpStatus.OK.value(), title, detail);
    }
    //执行失败，状态码为203
    protected AbstractBaseResult error(String detail) {
        // return error(HttpStatus.UNAUTHORIZED.value(), title, detail);
        return BaseResultFactory.getInstance(response).build(detail);
    }
    /**
     * 请求失败
     * @return
     */
    protected AbstractBaseResult userError() {
        // return error(HttpStatus.UNAUTHORIZED.value(), title, detail);
        return error(201, "用户没登陆", "");
    }
    /**
     * 请求失败
     * @return
     */
    protected AbstractBaseResult sentinelError() {
        // return error(HttpStatus.UNAUTHORIZED.value(), title, detail);
        return error(202, "熔断异常，请刷新重试", "");
    }
    /**
     * 请求失败
     * @param code
     * @param title
     * @param detail
     * @return
     */
    protected AbstractBaseResult error(int code, String title, String detail) {
        return BaseResultFactory.getInstance(response).build(code, title, detail, applicationContext.getEnvironment().getProperty(ENVIRONMENT_LOGGING_LEVEL_MY_SHOP));
    }
}
