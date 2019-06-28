package cn.bored.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "friends")
public class Friends extends  BaseEntity{
    /**
     * 标识列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 好友的id
     */
    @Column(name = "friend_user_id")
    private Long friendUserId;

    /**
     * 朋友的备注
     */
    @Column(name = "friend_nicename")
    private String friendNicename;

    }
