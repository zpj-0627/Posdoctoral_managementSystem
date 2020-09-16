package com.province.postdoctor.entity.results_of_station;

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
    @TableName("fundapplication")
    public class Fundapplication implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private String faName;

    private Date faDate;

    private String approvalNumber;

    private Date approvalTime;

    private String fundName;

    private String fundGrade;


}
