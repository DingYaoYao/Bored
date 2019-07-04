package cn.bored.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Table(name = "friends")
@EqualsAndHashCode(callSuper=false)
public class Friends extends BaseEntity {


    /**
     * 用户id
     */
    private Long userid;

    /**
     * 好友的id
     */
    @Column(name = "friend_user_id")
    private String friendUserId;

    /**
     * 朋友的备注
     */
    @Column(name = "friend_nicename")
    private String friendNicename;
}
