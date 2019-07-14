package cn.bored.common.web;

import cn.bored.common.dto.AbstractBaseDomain;

import cn.bored.common.dto.BaseResultFactory;
import cn.bored.common.dto.DtoResult;
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
//失败
    public DtoResult<T> error(){
        return error(null,null);
    }
  public DtoResult<T> error(String message){
        return error(message,null);
  }
    public DtoResult<T> error(String message,T dto){
        return init(response,HttpStatus.UNAUTHORIZED.value()).build(message,dto,HttpStatus.UNAUTHORIZED.value());
    }
//成功
    public DtoResult<T> success(){
        return success(null,null);
    }
    public DtoResult<T> success(String message){
        return success(message,null);
    }
    public DtoResult<T> success(T dto){
        return success(null,dto);
    }
    public DtoResult<T> success(String message,T dto){
        return init(response,HttpStatus.OK.value()).build(message,dto,HttpStatus.OK.value());
    }

    public BaseResultFactory init(HttpServletResponse response,Integer code){
        response.setStatus(code);
        return BaseResultFactory.getInstance(response);
    }
}
