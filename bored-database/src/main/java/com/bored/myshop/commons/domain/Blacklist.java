package com.bored.myshop.commons.domain;

import javax.persistence.*;

@Table(name = "bored..blacklist")
public class Blacklist {
    /**
     * 拉黑的人
     */
    private Long userid;

    /**
     * 被拉黑的
     */
    private Long fouserid;

    /**
     * 获取拉黑的人
     *
     * @return userid - 拉黑的人
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置拉黑的人
     *
     * @param userid 拉黑的人
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取被拉黑的
     *
     * @return fouserid - 被拉黑的
     */
    public Long getFouserid() {
        return fouserid;
    }

    /**
     * 设置被拉黑的
     *
     * @param fouserid 被拉黑的
     */
    public void setFouserid(Long fouserid) {
        this.fouserid = fouserid;
    }
}