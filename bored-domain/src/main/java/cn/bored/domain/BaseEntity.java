package cn.bored.domain;

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
public class BaseEntity  implements Serializable {

    private Long id;


}
