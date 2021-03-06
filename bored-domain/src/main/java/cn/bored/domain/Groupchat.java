package cn.bored.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Table(name = "groupchat")
@EqualsAndHashCode(callSuper=false)
public class Groupchat extends BaseEntity {


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

}
