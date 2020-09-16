package com.province.postdoctor.entity.project_application;

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
* @author zpj
* @since 2020-09-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("details")
    public class Details implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer aId;

    private String pName;

    private Date pTime;

            /**
            * 1为首次申请，0为2次申请
            */
    private Integer firstApplication;

    private String project;

    private Double fundsInput;


}
