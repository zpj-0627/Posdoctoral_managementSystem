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
    @TableName("meeting_information")
    public class MeetingInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pId;

    private Integer dId;

    private String meetingName;

    private Date meetingtime;

    private String place;

            /**
            * 在国内为1，在国外为0
            */
    private Integer inCountry;

            /**
            * 在省内为1，在省外为0
            */
    private Integer inProvince;


}
