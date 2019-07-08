package cn.bored.commons.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "friend")
public class Friend{


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
    private String Image_path;



    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 预留的视频路径
     */

    @Column(name = "Video_path")
    private String Video_path;

    /**
     * 点赞
     */
    private Integer like;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImage_path() {
        return Image_path;
    }

    public void setImage_path(String image_path) {
        Image_path = image_path;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getVideo_path() {
        return Video_path;
    }

    public void setVideo_path(String video_path) {
        Video_path = video_path;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
}
