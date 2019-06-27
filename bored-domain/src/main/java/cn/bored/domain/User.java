package cn.bored.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name = "user")
public class User {
    /**
     * 账号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @Column(name = "niceName")
    private String nicename;

    /**
     * 签名
     */
    private String signature;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 1=男 2=女
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 详细地址
     */
    @Column(name = "address_id")
    private String addressId;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 头像路径
     */
    private String picturepath;

    /**
     * 最近登录时间
     */
    @Column(name = "lately_login_date")
    private Date latelyLoginDate;

    /**
     * 登陆状态
     */
    @Column(name = "loginStat")
    private Integer loginstat;

   }
