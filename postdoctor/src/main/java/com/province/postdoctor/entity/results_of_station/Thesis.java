package com.province.postdoctor.entity.results_of_station;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author zpj
* @since 2020-09-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("thesis")
    public class Thesis implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private String tTtitle;

    private String tEtitle;

    private String academic;

    private String issueYear;

    private String issueVolume;

    private String issueTime;

    private String literature;

    private String rank;

    private String issuing;

    private String collection;

    private String ename;

    private String url;

    private String doi;

    private String wos;

    private String cremark;

    private String accessionnumber;

    private Integer cauthor;


}
