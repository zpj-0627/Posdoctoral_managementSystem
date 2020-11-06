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
* @since 2020-11-05
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("postdoctorrinformation")
    public class Postdoctorrinformation implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 博士号
            */
    private Integer pId;

            /**
            * 博士后名字
            */
    private String pName;

            /**
            * 部门id
            */
    private String dId;

            /**
            * 部门名称
            */
    private String dName;

            /**
            * 单位类型
            */
    private String dType;

            /**
            * 招收类型
            */
    private String recruitType;

            /**
            * 学科领域id
            */
    private String subjectAreaId;

            /**
            * 学科领域
            */
    private String subjectArea;

            /**
            * 学科门类
            */
    private String subjectCategory;

            /**
            * 一级学科
            */
    private String fSubject;

            /**
            * 性别
            */
    private String pSex;

            /**
            * 出生日期
            */
    private Date pBDate;

            /**
            * 民族
            */
    private String pNation;

            /**
            * 婚姻状况
            */
    private String pMarriage;

            /**
            * 国别
            */
    private String pNationality;

            /**
            * 证件名称
            */
    private String pPapers;

            /**
            * 证件号
            */
    private String pIdNumber;

            /**
            * 政治面貌
            */
    private String pPStatus;

            /**
            * 进站时间
            */
    private Date startStation;

            /**
            * 出站时间
            */
    private Date endStation;

            /**
            * 入党日期
            */
    private Date pJpDate;

            /**
            * 在站状态
            */
    private String status;

    /**
     * 出站去向
     */
    private String outbound;

            /**
            * 专业技术职称
            */
    private String pPTitle;

            /**
            * 联系电话
            */
    private String pCNumber;

            /**
            * 在职单位地址
            */
    private String pUnitAddress;

            /**
            * 手机号码
            */
    private String pPNumber;

            /**
            * 电子邮箱
            */
    private String pEmail;

            /**
            * 出生城市
            */
    private String pBCity;

            /**
            * 现户籍城市
            */
    private String pChrCity;

            /**
            * 籍贯
            */
    private String pNativePlace;

            /**
            * 现户籍所在详细地址
            */
    private String pPcdAddress;

            /**
            * 现户籍注册派出所
            */
    private String pPStation;

            /**
            * 现居住详细地址
            */
    private String pPrAddress;

            /**
            * 通讯地址（含邮编）
            */
    private String pMAddress;

            /**
            * 删除标志
            */
    private Integer sign;


}
