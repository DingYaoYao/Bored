package cn.bored.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "provinces")
public class Provinces extends BaseEntity {

    private Integer provinceid;

    private String province;


}
