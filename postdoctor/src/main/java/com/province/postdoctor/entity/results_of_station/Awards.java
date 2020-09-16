package com.province.postdoctor.entity.results_of_station;

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
    public class Awards implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private String pName;

    private String type;

    private String projectName;

    private String awardsName;

    private String awardsDateY;

    private String awardsDateM;

    private String awardsType;

    private String awardsGrade;

    private String awardsCategories;

    private String resultsAssessment;

    private Integer ranking;

    private String projectBrief;

    private String resultsDescribed;


}
