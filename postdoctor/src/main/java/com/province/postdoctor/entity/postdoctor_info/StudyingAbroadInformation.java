package com.province.postdoctor.entity.postdoctor_info;

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
* @since 2020-09-16
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("studying_abroad_information")
    public class StudyingAbroadInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private Integer studyingAbroad;

    private String saNationality;

    private String saId;

    private String saStartDateY;

    private String saStartDateM;

    private String saEndDateY;

    private String saEndDateM;

    private String saSchool;


}
