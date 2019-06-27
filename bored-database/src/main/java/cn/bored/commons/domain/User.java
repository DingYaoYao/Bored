package cn.bored.commons.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bored..user")
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

    /**
     * 获取账号
     *
     * @return id - 账号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置账号
     *
     * @param id 账号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return niceName - 昵称
     */
    public String getNicename() {
        return nicename;
    }

    /**
     * 设置昵称
     *
     * @param nicename 昵称
     */
    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    /**
     * 获取签名
     *
     * @return signature - 签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置签名
     *
     * @param signature 签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取1=男 2=女
     *
     * @return sex - 1=男 2=女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置1=男 2=女
     *
     * @param sex 1=男 2=女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取详细地址
     *
     * @return address_id - 详细地址
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * 设置详细地址
     *
     * @param addressId 详细地址
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取头像路径
     *
     * @return picturepath - 头像路径
     */
    public String getPicturepath() {
        return picturepath;
    }

    /**
     * 设置头像路径
     *
     * @param picturepath 头像路径
     */
    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    /**
     * 获取最近登录时间
     *
     * @return lately_login_date - 最近登录时间
     */
    public Date getLatelyLoginDate() {
        return latelyLoginDate;
    }

    /**
     * 设置最近登录时间
     *
     * @param latelyLoginDate 最近登录时间
     */
    public void setLatelyLoginDate(Date latelyLoginDate) {
        this.latelyLoginDate = latelyLoginDate;
    }

    /**
     * 获取登陆状态
     *
     * @return loginStat - 登陆状态
     */
    public Integer getLoginstat() {
        return loginstat;
    }

    /**
     * 设置登陆状态
     *
     * @param loginstat 登陆状态
     */
    public void setLoginstat(Integer loginstat) {
        this.loginstat = loginstat;
    }
}