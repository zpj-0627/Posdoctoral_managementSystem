package com.province.postdoctor.entity.daily_sci_act;

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
    @TableName("project_application")
    public class ProjectApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private Integer aId;

    private String name;

    private String type;

    private String applicant;

    private String company;

    private Date time;

    private String situation;


}
