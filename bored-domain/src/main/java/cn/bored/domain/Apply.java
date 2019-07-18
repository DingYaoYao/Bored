package cn.bored.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Table(name = "apply")
public class Apply extends BaseEntity implements  Serializable{

    private static final long serialVersionUID = 2174158115699351071L;
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
