package cn.bored.domain;

import lombok.Data;

import javax.persistence.Table;
@Data
@Table(name = "sensitiveword")
public class Sensitiveword  extends  BaseEntity{
    /**
     * 敏感词汇
     */
    private String sensitiveword;

    /**
     * 友好提示
     */
    private String hint;


}
