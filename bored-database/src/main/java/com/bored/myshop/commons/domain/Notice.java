package com.bored.myshop.commons.domain;

import javax.persistence.*;

@Table(name = "bored..notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text1;

    private String text2;

    private String text3;

    private String text4;

    private String text5;

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
     * @return text1
     */
    public String getText1() {
        return text1;
    }

    /**
     * @param text1
     */
    public void setText1(String text1) {
        this.text1 = text1;
    }

    /**
     * @return text2
     */
    public String getText2() {
        return text2;
    }

    /**
     * @param text2
     */
    public void setText2(String text2) {
        this.text2 = text2;
    }

    /**
     * @return text3
     */
    public String getText3() {
        return text3;
    }

    /**
     * @param text3
     */
    public void setText3(String text3) {
        this.text3 = text3;
    }

    /**
     * @return text4
     */
    public String getText4() {
        return text4;
    }

    /**
     * @param text4
     */
    public void setText4(String text4) {
        this.text4 = text4;
    }

    /**
     * @return text5
     */
    public String getText5() {
        return text5;
    }

    /**
     * @param text5
     */
    public void setText5(String text5) {
        this.text5 = text5;
    }
}