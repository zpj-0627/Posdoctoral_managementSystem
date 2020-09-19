package com.province.postdoctor.entity.station_info;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author tykj
* @since 2020-09-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("gzz_information")
    public class GzzInformation implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String dId;

    private String dName;

    private String dEname;

    private String professions;

    private String dType;

    private String domain;

    private String chdepartment;

    private String cddepartment;

    private String comaddress;

    private Integer zipcode;

    private String fixedphone;

    private String fax;

    private String email;

    private String fJob;

    private String sJob;


}
