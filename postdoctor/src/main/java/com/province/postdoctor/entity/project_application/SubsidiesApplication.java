package com.province.postdoctor.entity.project_application;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author zpj
* @since 2020-09-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("subsidies_application")
    public class SubsidiesApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

        @TableField("w_Id")
    private Integer wId;

    private Integer fId;

    private String company;

    private Integer account;

    private String standInfo;

    private String limits;

    private Date time;

    private Integer sign;


}
