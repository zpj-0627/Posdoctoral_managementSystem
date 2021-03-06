package com.province.postdoctor.entity.postdoctor_info;

    import cn.afterturn.easypoi.excel.annotation.Excel;
    import com.baomidou.mybatisplus.annotation.IdType;
    import java.sql.Date;

    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;
    import org.springframework.format.annotation.DateTimeFormat;

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

            @Excel(name = "专利权人")
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

            @Excel(name = "专利名称")
            private String patentName;

            /**
            * 专利申请日
            */
            private Date papplydate;


            /**
            * 公开日
            */
            private Date opendate;



            /**
            * 发明人
            */
    private String inventor;

            /**
            * 专利号
            */

            @Excel(name = "专利号")
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
    private String authorized;

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
