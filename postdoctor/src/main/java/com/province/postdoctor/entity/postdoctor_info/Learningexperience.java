package com.province.postdoctor.entity.postdoctor_info;

    import java.io.Serializable;
    import java.sql.Date;
    import java.util.List;

    import com.baomidou.mybatisplus.annotation.TableField;
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
    public class Learningexperience implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
    private int id;

    /**
     * 博士号
     */
    private Integer pId;
    /**
     * 博士名字
     */
    private String pName;

    /**
     * 单位编号
     */
    private String dId;

    /**
     * 单位名字
     */
    private String dName;
            /**
            * 起始时间
            */
    private Date lestartdate;

            /**
            * 终止时间
            */
    private Date leenddate;

            /**
            * 学校
            */
    private String school;

            /**
            * 学历
            */
    private String education;

            /**
            * 一级学科
            */
    private String smName1;

            /**
            * 二级学科
            */
    private String smName2;
    
    @TableField(exist = false)
    private List<Learningexperience> learningexperienceList;

}
