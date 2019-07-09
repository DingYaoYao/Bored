package cn.bored.domain;

import cn.bored.common.dto.AbstractBaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-27 16:40
 **/
@Data
public class BaseEntity extends AbstractBaseDomain implements Serializable{


    private static final long serialVersionUID = -6451654460016643511L;
}
