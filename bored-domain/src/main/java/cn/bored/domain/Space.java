package cn.bored.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name = "space")
public class Space extends  BaseEntity{
    /**
     * 空间编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
