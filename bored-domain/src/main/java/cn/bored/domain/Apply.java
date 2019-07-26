package cn.bored.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Table(name = "apply")
public class Apply extends BaseEntity implements  Serializable{

    private static final long serialVersionUID = 2174158115699351071L;
    /**
     * 该注解需要保留，用于 tk.mybatis 回显 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromUser() {
        return fromUser;
    }

    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}
