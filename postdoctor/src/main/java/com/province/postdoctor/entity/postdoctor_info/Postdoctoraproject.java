package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.sql.Date;

    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

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
* @since 2020-10-16
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Postdoctoraproject implements Serializable {

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
            * 单位类型
            */
    private String dType;

            /**
            * 博士ID
            */
    private Integer pId;

            /**
            * 博士名
            */
    private String pName;

            /**
            * 研究项目名称
            */
    private String projectName;

            /**
            * 下达部门
            */
    private String departmentName;

            /**
            * 项目性质名称
            */
    private String projectNature;

            /**
            * 项目进展名称
            */
    private String projectProgress;

            /**
            * 项目金额
            */
    private String projectSum;

            /**
            * 批准时间
            */


            private Date approveTime;
    /**
     * 获奖时间
     */

    @TableField(exist=false)
    private String showtime;

            /**
            * 承担责任名称
            */
    private String duty;


}
