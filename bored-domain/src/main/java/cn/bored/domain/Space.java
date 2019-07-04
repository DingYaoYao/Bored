package cn.bored.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Table(name = "space")
@EqualsAndHashCode(callSuper=false)
public class Space extends BaseEntity {


    /**
     * 话题主题id
     */
    private Integer titleid;

    /**
     * 投放者
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 1=有效 0=无效
     */
    private Integer state;


}
