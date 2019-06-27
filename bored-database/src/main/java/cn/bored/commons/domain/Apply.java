package cn.bored.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bored..apply")
public class Apply {
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

    /**
     * 获取申请编号
     *
     * @return id - 申请编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置申请编号
     *
     * @param id 申请编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取申请用户
     *
     * @return from_user - 申请用户
     */
    public Long getFromUser() {
        return fromUser;
    }

    /**
     * 设置申请用户
     *
     * @param fromUser 申请用户
     */
    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * 获取被申请用户
     *
     * @return to_user - 被申请用户
     */
    public Long getToUser() {
        return toUser;
    }

    /**
     * 设置被申请用户
     *
     * @param toUser 被申请用户
     */
    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    /**
     * 获取附加消息
     *
     * @return message - 附加消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置附加消息
     *
     * @param message 附加消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取申请状态
     *
     * @return status - 申请状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置申请状态
     *
     * @param status 申请状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取申请时间
     *
     * @return apply_date - 申请时间
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请时间
     *
     * @param applyDate 申请时间
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}