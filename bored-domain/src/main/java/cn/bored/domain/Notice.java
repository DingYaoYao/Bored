package cn.bored.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "notice")
@EqualsAndHashCode(callSuper=false)
public class Notice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text1;

    private String text2;

    private String text3;

    private String text4;

    private String text5;


}
