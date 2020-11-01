package com.province.postdoctor.entity.postdoctor_info;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.sql.Date;
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
* @since 2020-10-12
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Treatise implements Serializable {

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
            * 发明人ID
            */
    private Integer pId;

            /**
            * 发明人
            */
    private String pName;

            /**
            * 论著名称
            */
    private String treatiseName;

            /**
            * 论著方式
            */
    private String treatiseType;

            /**
            * 出版日期
            */
    private Date publicationDate;

            /**
            * 书号
            */
    private String treatiseNumber;

            /**
            * 出版社
            */
    private String press;

            /**
            * 作者排名
            */
    private String authorRank;


}
