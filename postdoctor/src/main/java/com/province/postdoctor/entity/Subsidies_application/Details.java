package com.province.postdoctor.entity.Subsidies_application;

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
* @author tykj
* @since 2020-11-07
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("details")
    public class Details implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
    private Integer id;

            /**
            * 补助申请id
            */
    private String applicationId;

            /**
            * 博士号
            */
    private Integer pId;

            /**
            * 博士后名字
            */
    private String pName;

            /**
            * 单位号
            */
    private String dId;

            /**
            * 单位名称
            */
    private String dName;

            /**
            * 流动站名称
            */
    private String ldzName;

            /**
            * 申报时间
            */
    private Date applicationTime;

            /**
            * 进站时间
            */
    private Date startStation;

            /**
            * 是否为第一次申请
            */
    private String firstApplication;

            /**
            * 项目名称
            */
    private String projectName;

            /**
            * 经费投入
            */
    private String fundsInput;

            /**
            * 申报情况
            */
    private String status;
}
