package cn.bored.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "topic")
public class Topic extends  BaseEntity{
    /**
     * 标识列自增加
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 话题的标题
     */
    private String headline;

    /**
     * 用户id
     */
    private Long userid;


}
