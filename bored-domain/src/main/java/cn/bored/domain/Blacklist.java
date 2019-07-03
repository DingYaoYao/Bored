package cn.bored.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "blacklist")
public class Blacklist extends BaseEntity {

    /**
     * 拉黑的人
     */
    private Long userid;

    /**
     * 被拉黑的
     */
    private Long fouserid;

}
