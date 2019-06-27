package com.bored.myshop.commons.domain;

import javax.persistence.*;

@Table(name = "bored..sensitiveword")
public class Sensitiveword {
    /**
     * 敏感词汇
     */
    private String sensitiveword;

    /**
     * 友好提示
     */
    private String hint;

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