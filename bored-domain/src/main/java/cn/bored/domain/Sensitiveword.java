package cn.bored.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sensitiveword")
public class Sensitiveword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 敏感词汇
     */
    private String sensitiveword;

    /**
     * 友好提示
     */
    private String hint;

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
     * 获取敏感词汇
     *
     * @return sensitiveword - 敏感词汇
     */
    public String getSensitiveword() {
        return sensitiveword;
    }

    /**
     * 设置敏感词汇
     *
     * @param sensitiveword 敏感词汇
     */
    public void setSensitiveword(String sensitiveword) {
        this.sensitiveword = sensitiveword;
    }

    /**
     * 获取友好提示
     *
     * @return hint - 友好提示
     */
    public String getHint() {
        return hint;
    }

    /**
     * 设置友好提示
     *
     * @param hint 友好提示
     */
    public void setHint(String hint) {
        this.hint = hint;
    }
}
