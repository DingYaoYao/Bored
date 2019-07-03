package cn.bored.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "friend")
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
    @Column(name = "Image_path")
    private String imagePath;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 预留的视频路径
     */
    @Column(name = "Video_path")
    private String videoPath;

    /**
     * 点赞
     */
    private Integer like;

}
