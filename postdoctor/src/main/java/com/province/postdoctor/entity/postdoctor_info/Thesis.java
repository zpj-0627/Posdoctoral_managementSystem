package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import java.sql.Date;
    import java.util.List;

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
* @since 2020-10-10
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Thesis implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String dId;

            /**
            * 单位名称
            */
    private String dName;

            /**
            * 博士号
            */
    private Integer pId;

            /**
            * 博士名称
            */
    private String pName;

            /**
            * 论文题目
            */
    private String tTitle;

            /**
            * 论文英文题目
            */
    private String tEtitle;

    /**
     * 发表日期
     */
    private Date publishingtime;


            /**
            * 论文发表的学术刊物或会议名称
            */
    private String academic;

            /**
            * 卷期信息(年)
            */
    private String issueYear;

            /**
            * 卷期信息(卷)
            */
    private String issueVolume;

            /**
            * 卷期信息(期)
            */
    private String issueTime;

            /**
            * 文献类型
            */
    private String literature;

            /**
            * 论文作者排名
            */
    private String rank;

            /**
            * 期刊号
            */
    private String issuing;

            /**
            * 收录情况
            */
    private String collection;

            /**
            * 英文姓名
            */
    private String ename;

            /**
            * url
            */
    private String url;

            /**
            * doi
            */
    private String doi;

            /**
            * wos/入藏号
            */
    private String wos;

            /**
            * 收录情况备注
            */
    private String cremark;

            /**
            * accessionnumber
            */
    private String accessionnumber;

            /**
            * 是否通讯作者
            */
    private String cauthor;

    private Date publishingtimeStart;

    private Date publishingtimeEnd;

    @TableField(exist = false)
    private List<Thesis> thesisList;

}
