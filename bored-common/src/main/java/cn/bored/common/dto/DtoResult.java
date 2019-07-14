package cn.bored.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-14 10:39
 **/
@Data
public class DtoResult<T extends Object>  implements Serializable {

    private static final long serialVersionUID = 3503118331702318357L;

    private String message;
    private T data;
    private Integer code=200;




}
