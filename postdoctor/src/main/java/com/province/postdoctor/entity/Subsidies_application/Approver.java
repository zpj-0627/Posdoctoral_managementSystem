package com.province.postdoctor.entity.Subsidies_application;

    import com.baomidou.mybatisplus.annotation.IdType;
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
* @since 2020-11-07
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Approver implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 批准id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 补助申请id
            */
    private String applicationId;

            /**
            * 批准人名字
            */
    private String ldzName;

            /**
            * 批准人编号
            */
    private String approverId;

            /**
            * 批准人
            */
    private String approver;


}
