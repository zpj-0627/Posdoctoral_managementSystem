package com.province.postdoctor.entity.daily_sci_act;

    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import java.sql.Date;
    import java.util.List;

    import com.province.postdoctor.entity.postdoctor_info.Learningexperience;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;
    import org.springframework.format.annotation.DateTimeFormat;

/**
* <p>
    * 
    * </p>
*
* @author tykj
* @since 2020-10-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("project_application")
    public class ProjectApplication implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 申报项目id
     */
    private Integer projectId;

    /**
     * 申报单位id
     */
    private String dId;

    /**
     * 申报单位类型
     */
    private String dType;

    /**
     * 申报单位
     */
    private String dName;

            /**
            * 项目名称
            */
    private String projectName;

            /**
            * 项目类型
            */
    private String projectType;

            /**
            * 申请人姓名
            */
    private String applicant;

            /**
            * 申请时间
            */
    private Date applicantTime;

            /**
            * 批复情况
            */
    private String situation;

    /**
     * 申请开始时间
     */
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date applicantstartTime;

    /**
     * 申请结束时间
     */
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date applicantendTime;

    @TableField(exist = false)
    private List<ProjectApplication> projectApplicationList;


}
