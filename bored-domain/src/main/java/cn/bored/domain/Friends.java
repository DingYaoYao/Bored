package cn.bored.domain;

import javax.persistence.*;

@Table(name = "friends")
public class Friends {
    /**
     * 标识列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    /**
     * 获取标识列
     *
     * @return id - 标识列
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置标识列
     *
     * @param id 标识列
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * 获取好友的id
     *
     * @return friend_user_id - 好友的id
     */
    public String getFriendUserId() {
        return friendUserId;
    }

    /**
     * 设置好友的id
     *
     * @param friendUserId 好友的id
     */
    public void setFriendUserId(String friendUserId) {
        this.friendUserId = friendUserId;
    }

    /**
     * 获取朋友的备注
     *
     * @return friend_nicename - 朋友的备注
     */
    public String getFriendNicename() {
        return friendNicename;
    }

    /**
     * 设置朋友的备注
     *
     * @param friendNicename 朋友的备注
     */
    public void setFriendNicename(String friendNicename) {
        this.friendNicename = friendNicename;
    }
}
