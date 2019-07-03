package cn.bored.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "areas")
public class Areas {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取区县编码
     *
     * @return areaid - 区县编码
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * 设置区县编码
     *
     * @param areaid 区县编码
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    /**
     * 获取区县名称
     *
     * @return area - 区县名称
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区县名称
     *
     * @param area 区县名称
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取所属城市编码
     *
     * @return cityid - 所属城市编码
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * 设置所属城市编码
     *
     * @param cityid 所属城市编码
     */
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
}
