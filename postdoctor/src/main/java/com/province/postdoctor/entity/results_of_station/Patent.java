package com.province.postdoctor.entity.results_of_station;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.util.Date;
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
    @TableName("patent")
    public class Patent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private String patentName;

    private Date papplydate;

    private String pnumber;

    private Date opendate;

    private String onumber;

    private String inventor;

    private String patenter;

    private String ptype;

    private Integer authorized;

    private Integer rank;

    private String papprove;

    private String pbrief;


}
