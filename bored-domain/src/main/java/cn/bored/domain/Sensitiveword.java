package cn.bored.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sensitiveword")
public class Sensitiveword extends BaseEntity {

    /**
     * 敏感词汇
     */
    private String sensitiveword;

    /**
     * 友好提示
     */
    private String hint;


}
