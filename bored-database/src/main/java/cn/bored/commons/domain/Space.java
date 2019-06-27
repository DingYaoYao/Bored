package cn.bored.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bored..space")
public class Space {
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

    /**
     * 获取空间编号
     *
     * @return id - 空间编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置空间编号
     *
     * @param id 空间编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取话题主题id
     *
     * @return titleid - 话题主题id
     */
    public Integer getTitleid() {
        return titleid;
    }

    /**
     * 设置话题主题id
     *
     * @param titleid 话题主题id
     */
    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    /**
     * 获取投放者
     *
     * @return userId - 投放者
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置投放者
     *
     * @param userid 投放者
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取1=有效 0=无效
     *
     * @return state - 1=有效 0=无效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1=有效 0=无效
     *
     * @param state 1=有效 0=无效
     */
    public void setState(Integer state) {
        this.state = state;
    }
}