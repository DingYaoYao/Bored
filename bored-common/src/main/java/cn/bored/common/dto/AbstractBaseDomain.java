package cn.bored.common.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 通用的领域模型
 * <p>Title: AbstractBaseDomain</p>
 * <p>Description: </p>
 *
 * @author Ding
 * @version 1.0.0
 * @date 2019/1/23 15:50
 */

public abstract class AbstractBaseDomain implements Serializable {

    private static final long serialVersionUID = 1739981318655410197L;
    /**
     * 该注解需要保留，用于 tk.mybatis 回显 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
