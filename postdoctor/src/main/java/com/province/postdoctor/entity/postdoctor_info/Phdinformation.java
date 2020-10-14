package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
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
* @since 2020-10-14
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("phdinformation")
    public class Phdinformation implements Serializable {

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
            * 单位id
            */
    private String dId;

            /**
            * 单位名字
            */
    private String dName;

            /**
            * 博士学位论文题目
            */
    private String dDissertationTopic;

            /**
            * 博士论文指导老师
            */
    private String dThesisAdvisor;

            /**
            * 是否已取得博士学位
            */
    private Integer dDegreeCertificate;

            /**
            * 博士证书签发时间
            */
    private Date ddcSignDate;

            /**
            * 博士论文答辩通过时间
            */
    private Date ddDefenseDate;

            /**
            * 所获博士学位国别
            */
    private String dDegreeNationality;

            /**
            * 博士毕业单位
            */
    private String dDoctoralUnit;

            /**
            * 获得博士学位一
            */
    private String dSmName1;

            /**
            * 获得博士学位二
            */
    private String dSmName2;

            /**
            * 博士论文摘要
            */
    private String ddAbstract;

            /**
            * 科研成果奖励和荣誉称号
            */
    private String srHoners;


}
