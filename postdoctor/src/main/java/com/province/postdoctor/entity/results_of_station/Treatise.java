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
    @TableName("treatise")
    public class Treatise implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private String treatiseName;

    private String treatiseNumber;

    private String press;

    private Date publicationDate;

    private String treatiseMode;

    private Integer authorRank;


}
