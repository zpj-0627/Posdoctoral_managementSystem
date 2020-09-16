package com.province.postdoctor.entity.project_application;

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
    public class Approver implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer aId;

    private String approverName;

    private Date time;

    private String opinion;

            /**
            * 是否通过：1为通过，0为未通过
            */
    private Integer pass;


}
