package cn.bored.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "topic")
@EqualsAndHashCode(callSuper=false)
public class Topic extends BaseEntity {


    /**
     * 话题的标题
     */
    private String headline;

    /**
     * 用户id
     */
    private Long userid;


}
