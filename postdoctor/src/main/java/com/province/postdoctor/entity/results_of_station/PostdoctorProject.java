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
* @since 2020-09-16
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("postdoctor_project")
    public class PostdoctorProject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private String projectName;

    private String departmentName;

    private String projectNature;

    private String projectProgress;

    private String projectSum;

    private Date approveTime;

    private String duty;


}
