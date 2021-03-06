package cn.bored.domain;

import cn.bored.common.utils.RegexpUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "user")
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends  BaseEntity implements Serializable {
    private static final long serialVersionUID = -4586384302646087434L;
    /**
     * im  用户标识
     */
    private String accid;
    @Column(name = "backImg")
    private String backImg;
    /**
     * 身份验证标识
     */
    private String token;
    /**
     * 账号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @Length(min = 1, max = 20, message = "用户密码长度必须介于 1 和 20 之间")
   // @JsonIgnore
    private String password;

    /**
     * 昵称
     */
    @NotNull(message = "用户昵称不可为空")
    @Length(min = 1, max = 20, message = "用户昵称长度必须介于 1 和 20 之间")
    @Column(name = "niceName")
    private String nicename;

    /**
     * 签名
     */
    @Length(min = 1, max = 50, message = "个性签名长度必须介于 1 和 20 之间")
    private String signature;

    /**
     * 邮箱
     */
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
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
     * 格式化日期，由于是北京时间（我们是在东八区），所以时区 +8
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date update_date;
    /**
     * 详细地址
     */
    @Column(name = "address_id")
    private String addressId;

    /**
     * 电话号码
     */
    @NotNull(message = "手机号不可为空")
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;

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
