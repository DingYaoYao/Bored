package cn.bored.common.web;

import cn.bored.common.dto.AbstractBaseDomain;

import cn.bored.common.dto.BaseResultFactory;
import cn.bored.common.dto.DtoResult;
import cn.bored.common.utils.ConstantParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
@Component
public class AbstractBaseController<T extends Object> {

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

    //权限
    public DtoResult<T> userError() {
        return init(response).build("用户没登陆", 201);
    }

    //失败
    public DtoResult<T> error() {
        return error("\"网络异常，请重试\"", null);
    }

    public DtoResult<T> error(String message) {
        return error(message, null);
    }

    public DtoResult<T> error(String message, T dto) {
        return init(response).build(message, dto, ConstantParams.CODE_ERROR);
    }

    //成功
    public DtoResult<T> success() {
        return success(null, null);
    }

    public DtoResult<T> success(String message) {
        return success(message, null);
    }

    public DtoResult<T> success(T dto) {
        return success(null, dto);
    }

    public DtoResult<T> success(String message, T dto) {
        return init(response).build(message, dto, ConstantParams.CODE_OK);
    }


    //使用模板结果
    public DtoResult<T> templete(DtoResult<T> dto){
        //熔断
        if (StringUtils.isEmpty(dto)) {
            return error();
        }
        //成功
        if(dto.getCode() == ConstantParams.CODE_OK){
            if(dto.getData()!=null)return dto;
            return success();
            //失败
        }else{
            return dto;
        }

    }
    //设置参数，集合，单个对象，等

    //判断方法是否执行成功
    public Boolean isSuccess(DtoResult<T> dto) {
        if (!StringUtils.isEmpty(dto)) {
            if (dto.getCode() == ConstantParams.CODE_OK) {
                return true;
            }
        }
        return false;
    }

    public BaseResultFactory init(HttpServletResponse response) {

        return BaseResultFactory.getInstance(response);
    }
}
