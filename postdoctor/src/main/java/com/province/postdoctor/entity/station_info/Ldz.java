package com.province.postdoctor.entity.station_info;

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
    public class Ldz implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer fId;

    private Integer dId;

    private String lname;

    private String lcompany;

    private String lsubject;


}
