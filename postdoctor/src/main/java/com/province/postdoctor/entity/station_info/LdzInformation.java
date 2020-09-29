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
    @TableName("ldz_information")
    public class LdzInformation implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String dId;

    private String dName;

    private String hcompany;

    private String dType;

    private String department;

    private String fSubject;

    private String province;

    private String area;

    private String remark;

    private String dEname;

    private String cddepartment;

    private String aname;

    private String comaddress;

    private Integer zipcode;

    private String fixedphone;

    private String fax;

    private Integer phone;

    private String email;


}
