package cn.bored.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "friend")
@EqualsAndHashCode(callSuper=false)
public class Friend extends BaseEntity {


    /**
     * 用户id
     */
    private Long userid;

    /**
     * 内容
     */
    private String context;

    /**
     * 图片和视频的路径逗号分隔
     */
    private String Image_path;



    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 预留的视频路径
     */

    private String Video_path;

    /**
     * 点赞
     */
    private Integer like;

}
