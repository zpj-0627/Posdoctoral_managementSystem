package com.province.postdoctor.entity.Subsidies_application;

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
* @since 2020-11-07
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("subsidies_application")
    public class SubsidiesApplication implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 补助申请id
            */
    private String applicationId;

            /**
            * 单位id
            */
    private String dId;

            /**
            * 单位名字
            */
    private String dName;

            /**
            * 流动站名字
            */
    private String ldzName;

            /**
            * 申请时间
            */
    private Date applicationTime;

            /**
             * 开户银行
             */
    private String bank;

            /**
             * 账户
             */
    private String account;

            /**
            * 状态
            */
    private String state;
            /**
             * 批改意见
             */
    private String opinion;

            /**
            * 删除标志
            */
    private Integer sign;


}
