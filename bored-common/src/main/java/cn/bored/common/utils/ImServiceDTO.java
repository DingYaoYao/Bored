package cn.bored.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * @author: hanghang
 * @create: 2019-07-01 11:14
 **/
@Data
public class ImServiceDTO implements Serializable {

    private int  code;
    private String desc;
    private Info info;

    @Data
    public class  Info implements Serializable {
        private String token;
        private String accid;
        private String name;
    }

}
