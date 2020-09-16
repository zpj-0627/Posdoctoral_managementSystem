package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableName("postdoctorinfo")
    public class Postdoctorinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

        @TableField("w_Id")
    private Integer wId;

    private Integer pId;

    private Integer fId;

    private String pName;

    private String pSex;

    private Date pBDate;

    private String pNation;

    private String pMarriage;

    private String pNationality;

    private String pPapers;

    private String pIdNumber;

    private String pPStatus;

    private Date pJpDate;

    private String pPTitle;

    private String pCNumber;

    private Integer dId;

    private String dName;

    private String pUnitAddress;

    private String pPNumber;

    private String pEmail;

    private String pBProvince;

    private String pBCity;

    private String pChrProvince;

    private String pChrCity;

    private String pNativePlace;

    private String smName;

    private String pPcdAddress;

    private String pPStation;

    private String pPrAddress;

    private String pMAddress;

    private Integer sign;


}
