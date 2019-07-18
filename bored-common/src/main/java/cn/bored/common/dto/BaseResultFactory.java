package cn.bored.common.dto;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通用响应结构工厂
 * <p>Title: BaseResultFactory</p>
 * <p>Description: </p>
 *
 * @author Ding
 * @version 1.0.0
 * @date 2019/1/23 15:16
 */
@SuppressWarnings("all")
public class BaseResultFactory<T extends Object> {



    /**
     * 设置日志级别，用于限制发生错误时，是否显示调试信息(detail)
     *
     * @see ErrorResult#detail
     */
    public static final String LOGGER_LEVEL_DEBUG = "DEBUG";

    private static BaseResultFactory baseResultFactory;

    private BaseResultFactory() {

    }

    // 设置通用的响应
    private static HttpServletResponse response;

    public static BaseResultFactory getInstance(HttpServletResponse response) {
        if (baseResultFactory == null) {
            synchronized (BaseResultFactory.class) {
                if (baseResultFactory == null) {
                    baseResultFactory = new BaseResultFactory();
                }
            }
        }
        BaseResultFactory.response = response;
        // 设置通用响应
        baseResultFactory.initResponse();
        return baseResultFactory;
    }
    public DtoResult<T> build(String message){
        return build(message,null,null);
    }
    public DtoResult<T> build(Integer code){
        return build(null,null,code);
    }
    public DtoResult<T> build(String message,Integer code){
        return build(message,null,code);
    }
    public DtoResult<T> build(String message,T dto ,Integer code){
        DtoResult<T> tDtoResult = new DtoResult<>();
        tDtoResult.setCode(code);
        tDtoResult.setData(dto);
        tDtoResult.setMessage(message);
        return tDtoResult;
    }

    /**
     * 初始化 HttpServletResponse
     */
    private void initResponse() {
        // 需要符合 JSON API 规范
        response.setHeader("Content-Type", "application/vnd.api+json");
    }
}
