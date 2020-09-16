package com.province.postdoctor.entity.station_info;

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
* @author zpj
* @since 2020-09-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Gzz implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            @TableId("w_Id")
    private Integer wId;

    private Integer dId;

    private String gname;

    private String gcompany;


}
