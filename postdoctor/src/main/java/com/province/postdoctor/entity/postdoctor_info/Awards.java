package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import java.sql.Date;

    import com.fasterxml.jackson.annotation.JsonFormat;
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
* @since 2020-10-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Awards implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 单位ID
            */
    private String dId;

            /**
            * 单位名称
            */
    private String dName;

            /**
            * 博士ID
            */
    private Integer pId;

            /**
            * 博士名
            */
    private String pName;

            /**
            * 项目名称
            */
    private String projectName;

            /**
            * 类型
            */
    private String type;

            /**
            * 奖励名称
            */
    private String awardsName;

            /**
            * 获奖时间
            */

//            @DateTimeFormat(pattern = "yyyy-MM-dd")
//            @JsonFormat(pattern = "yyyy-MM-dd")
            private Date awardsDate;
    /**
     * 获奖时间
     */

    @TableField(exist=false)
    private String showtime;

            /**
            * 获奖类型
            */
    private String awardsType;

            /**
            * 等级
            */
    private String awardsGrade;

            /**
            * 奖励类别
            */
    private String awardsCategories;

            /**
            * 成果评价
            */
    private String resultsAssessment;

            /**
            * 排名
            */
    private String ranking;

            /**
            * 项目简介
            */
    private String projectBrief;

            /**
            * 成果描述
            */
    private String resultsDescribed;


}
