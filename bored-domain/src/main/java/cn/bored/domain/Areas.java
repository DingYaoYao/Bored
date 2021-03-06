package cn.bored.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "areas")
@EqualsAndHashCode(callSuper=false)
public class Areas extends BaseEntity {


    /**
     * 区县编码
     */
    private String areaid;

    /**
     * 区县名称
     */
    private String area;

    /**
     * 所属城市编码
     */
    private String cityid;


}
