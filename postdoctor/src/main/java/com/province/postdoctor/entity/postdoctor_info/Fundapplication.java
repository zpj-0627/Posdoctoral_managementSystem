package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.sql.Date;
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
* @since 2020-10-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Fundapplication implements Serializable {

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
            * 博士号
            */
    private Integer pId;

            /**
            * 博士名字
            */
    private String pName;

            /**
            * 申获基金名称
            */
    private String faName;

            /**
            * 基金名称
            */
    private String fundName;

            /**
            * 项目批准号
            */
    private String approvalNumber;

            /**
            * 基金级别名称
            */
    private String fundGrade;

            /**
            * 申请时间
            */
    private Date faDate;


            /**
            * 项目批准时间
            */
    private Date approvalTime;



}
