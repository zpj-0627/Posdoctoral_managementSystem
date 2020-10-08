package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.util.Date;
    import java.io.Serializable;
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
* @since 2020-10-05
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("postdoctorrinformation")
    public class Postdoctorrinformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            /**
            * 部门id
            */
    private String dId;

            /**
            * 部门名称
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
     * 部门类型
     */
    private Integer dType;

            /**
            * 性别
            */
    private String pSex;

            /**
            * 出生日期
            */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startStation;

            /**
            * 出站时间
            */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endStation;

            /**
             * 在站状态
             */
    private String status;

            /**
            * 入党日期
            */
            @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pJpDate;

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
            * 出生省份
            */
    private String pBProvince;

            /**
            * 出生城市
            */
    private String pBCity;

            /**
            * 现户籍省份
            */
    private String pChrProvince;

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
