package com.province.postdoctor.entity.postdoctor_info;

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
* @since 2020-09-16
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("phd_information")
    public class PhdInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private String dDissertationTopic;

    private String dThesisAdvisor;

    private Integer dDegreeCertificate;

    private Date ddcSignDate;

    private Date ddDefenseDate;

    private String dDegreeNationality;

    private String dDoctoralUnit;

    private String dSmName1;

    private String dSmName2;

    private String ddAbstract;

    private String srHoners;


}
