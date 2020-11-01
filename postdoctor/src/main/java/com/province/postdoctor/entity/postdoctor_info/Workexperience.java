package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import java.sql.Date;
    import java.util.List;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author tykj
* @since 2020-10-14
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Workexperience implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 博士号
            */
    private Integer pId;

            /**
            * 博士名字
            */
    private String pName;

            /**
            * 是否待业
            */
    private String employment;

            /**
            * 工作起始时间
            */
    private Date weStartDate;

            /**
            * 工作终止时间
            */
    private Date weEndDate;

            /**
            * 国别
            */
    private String nationality;

            /**
            * 工作单位名称
            */
    private String workUnit;

            /**
            * 职务
            */
    private String wePosition;

            /**
            * 身份
            */
    private String weIdentity;

            /**
            * 赞助方
            */
    private String weSponsorship;

            /**
            * 单位Id
            */
    private String dId;

            /**
            * 单位名称
            */
    private String dName;

    @TableField(exist = false)
    private List<Workexperience> workexperienceList;


}
