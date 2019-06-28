package cn.bored.domain;

import cn.bored.common.dto.AbstractBaseDomain;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-27 16:40
 **/
@Data
public class BaseEntity extends AbstractBaseDomain implements Serializable{

    private Long id;

}
