package cn.bored.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Data
@Table(name = "friends")
@EqualsAndHashCode(callSuper=false)
public class Friends extends BaseEntity {


    private String picturepath;
    private String friend_nicename;
    private String niceName;
    private String address_id;
    private String token;
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
