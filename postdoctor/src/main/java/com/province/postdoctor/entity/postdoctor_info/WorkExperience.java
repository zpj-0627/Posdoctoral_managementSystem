package com.province.postdoctor.entity.postdoctor_info;

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
* @since 2020-09-16
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class WorkExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private Integer employment;

    private String weStartDate;

    private String weEndDate;

    private String nationality;

    private String workUnit;

    private String wePosition;

    private String weIdentity;

    private String weSponsorship;


}
