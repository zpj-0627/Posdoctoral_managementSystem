package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
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
* @author tykj
* @since 2020-10-13
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Patent implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 单位ID
            */
    private String dId;

            /**
            * 单位名称
            */
    private String dName;

            /**
            * 专利权人
            */
    private String patenter;

            /**
            * 博士号
            */
    private Integer pId;

            /**
            * 博士名
            */
    private String pName;

            /**
            * 专利名称
            */
    private String patentName;

            /**
            * 专利申请日
            */
    private Date papplydate;

    /**
     * 专利申请日期
     */
    private String showtime;

            /**
            * 公开日
            */
    private Date opendate;

    /**
     * 公开日期
     */
    private String showtime1;

            /**
            * 发明人
            */
    private String inventor;

            /**
            * 专利号
            */
    private String pnumber;

            /**
            * 公开号
            */
    private String onumber;

            /**
            * 专利类型
            */
    private String ptype;

            /**
            * 是否授权
            */
    private Integer authorized;

            /**
            * 排名
            */
    private Integer rank;

            /**
            * 专利批准国
            */
    private String papprove;

            /**
            * 专利简介
            */
    private String pbrief;


}
