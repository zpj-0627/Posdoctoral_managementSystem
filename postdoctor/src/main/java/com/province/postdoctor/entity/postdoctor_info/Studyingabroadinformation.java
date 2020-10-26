package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import java.sql.Date;

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
    @TableName("studyingabroadinformation")
    public class Studyingabroadinformation implements Serializable {

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
            * 是否留学
            */
    private String studyingAbroad;

            /**
            * 留学国别
            */
    private String saNationality;

            /**
            * 留学身份
            */
    private String saId;


            /**
             * 出国前是否注销户口
             */
    private String saLogoff;

            /**
            * 留学开始时间
            */
    private Date saStartDate;


            /**
            * 留学结束时间
            */
    private Date saEndDate;

            /**
            * 留学学校
            */
    private String saSchool;

            /**
            * 单位编号
            */
    private String dId;

            /**
            * 单位名字
            */
    private String dName;


}
