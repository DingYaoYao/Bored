package cn.bored.domain;

import lombok.Data;

import javax.persistence.Table;
@Data
@Table(name = "blacklist")
public class Blacklist {
    /**
     * 拉黑的人
     */
    private Long userid;

    /**
     * 被拉黑的
     */
    private Long fouserid;

   }
