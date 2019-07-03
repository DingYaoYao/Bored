package cn.bored.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "cities")
public class Cities extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 城市编码
     */
    private String cityid;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 所属省份编码
     */
    private String provinceid;



    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取城市编码
     *
     * @return cityid - 城市编码
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * 设置城市编码
     *
     * @param cityid 城市编码
     */
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    /**
     * 获取城市名称
     *
     * @return city - 城市名称
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市名称
     *
     * @param city 城市名称
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所属省份编码
     *
     * @return provinceid - 所属省份编码
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * 设置所属省份编码
     *
     * @param provinceid 所属省份编码
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }
}
