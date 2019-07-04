package cn.bored.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "provinces")
@EqualsAndHashCode(callSuper=false)
public class Provinces extends BaseEntity {

    private Integer provinceid;

    private String province;


}
