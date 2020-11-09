package com.province.postdoctor.entity.Subsidies_application;

    import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableName("attachment")
    public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            /**
            * 补助申请id
            */
    private String applicationId;

            /**
            * 附件名称
            */
    private String fileName;

            /**
            * 附件地址路径
            */
    private String url;


}
