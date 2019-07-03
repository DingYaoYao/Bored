package cn.bored.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return userid - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取内容
     *
     * @return context - 内容
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置内容
     *
     * @param context 内容
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * 获取图片和视频的路径逗号分隔
     *
     * @return Image_path - 图片和视频的路径逗号分隔
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 设置图片和视频的路径逗号分隔
     *
     * @param imagePath 图片和视频的路径逗号分隔
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取预留的视频路径
     *
     * @return Video_path - 预留的视频路径
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * 设置预留的视频路径
     *
     * @param videoPath 预留的视频路径
     */
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    /**
     * 获取点赞
     *
     * @return like - 点赞
     */
    public Integer getLike() {
        return like;
    }

    /**
     * 设置点赞
     *
     * @param like 点赞
     */
    public void setLike(Integer like) {
        this.like = like;
    }
}
