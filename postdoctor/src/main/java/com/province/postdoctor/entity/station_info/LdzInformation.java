package com.province.postdoctor.entity.station_info;

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
    @TableName("ldz_information")
    public class LdzInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer dId;

    private String dName;

    private String hcompany;

    private String dType;

    private String department;

    private String province;

    private String area;

    private String remark;

    private String sign;


}
