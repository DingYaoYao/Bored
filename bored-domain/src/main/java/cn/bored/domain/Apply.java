package cn.bored.domain;

import com.google.common.io.BaseEncoding;

import javax.persistence.*;
import java.util.Date;

@Table(name = "apply")
public class Apply extends BaseEntity {


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
