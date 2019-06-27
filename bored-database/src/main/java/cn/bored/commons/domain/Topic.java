package cn.bored.commons.domain;

import javax.persistence.*;

@Table(name = "bored..topic")
public class Topic {
    /**
     * 标识列自增加
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 话题的标题
     */
    private String headline;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 获取标识列自增加
     *
     * @return id - 标识列自增加
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置标识列自增加
     *
     * @param id 标识列自增加
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取话题的标题
     *
     * @return headline - 话题的标题
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * 设置话题的标题
     *
     * @param headline 话题的标题
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * 获取用户id
     *
     * @return userid - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }
}