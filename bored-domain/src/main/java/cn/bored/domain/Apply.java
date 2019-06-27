package cn.bored.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "apply")
public class Apply extends  BaseEntity{
    /**
     * 申请编号
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 申请用户
     */
    @Column(name = "from_user")
    private Long fromUser;

    /**
     * 被申请用户
     */
    @Column(name = "to_user")
    private Long toUser;

    /**
     * 附加消息
     */
    private String message;

    /**
     * 申请状态
     */
    private Integer status;

    /**
     * 申请时间
     */
    @Column(name = "apply_date")
    private Date applyDate;

    }
