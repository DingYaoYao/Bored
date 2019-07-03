package cn.bored.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "groupchat")
public class Groupchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 群号
     */
    private Integer groupid;

    /**
     * 群名称
     */
    private String groupname;

    /**
     * 群主id
     */
    private Long groupuserid;

    /**
     * 群组成员id列表
     */
    @Column(name = "member_list")
    private String memberList;

    /**
     * 群成员昵称列表
     */
    private String displayname;

    /**
     * 群创建时间
     */
    private Date createtime;

    /**
     * 群主题id
     */
    private Integer grouptopicid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取群号
     *
     * @return groupid - 群号
     */
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * 设置群号
     *
     * @param groupid 群号
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    /**
     * 获取群名称
     *
     * @return groupname - 群名称
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * 设置群名称
     *
     * @param groupname 群名称
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    /**
     * 获取群主id
     *
     * @return groupuserid - 群主id
     */
    public Long getGroupuserid() {
        return groupuserid;
    }

    /**
     * 设置群主id
     *
     * @param groupuserid 群主id
     */
    public void setGroupuserid(Long groupuserid) {
        this.groupuserid = groupuserid;
    }

    /**
     * 获取群组成员id列表
     *
     * @return member_list - 群组成员id列表
     */
    public String getMemberList() {
        return memberList;
    }

    /**
     * 设置群组成员id列表
     *
     * @param memberList 群组成员id列表
     */
    public void setMemberList(String memberList) {
        this.memberList = memberList;
    }

    /**
     * 获取群成员昵称列表
     *
     * @return displayname - 群成员昵称列表
     */
    public String getDisplayname() {
        return displayname;
    }

    /**
     * 设置群成员昵称列表
     *
     * @param displayname 群成员昵称列表
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    /**
     * 获取群创建时间
     *
     * @return createtime - 群创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置群创建时间
     *
     * @param createtime 群创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取群主题id
     *
     * @return grouptopicid - 群主题id
     */
    public Integer getGrouptopicid() {
        return grouptopicid;
    }

    /**
     * 设置群主题id
     *
     * @param grouptopicid 群主题id
     */
    public void setGrouptopicid(Integer grouptopicid) {
        this.grouptopicid = grouptopicid;
    }
}
