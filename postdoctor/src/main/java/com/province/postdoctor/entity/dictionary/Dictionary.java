package com.province.postdoctor.entity.dictionary;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;

    import com.fasterxml.jackson.annotation.JsonProperty;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author tykj
* @since 2020-09-27
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("dictionary")
    public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;


//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;

    @JsonProperty("id")
    private String dictionaryId;

    @JsonProperty("title")
    private String name;

    @JsonProperty("parentId")
    private String updictionaryId;

    private Integer sign;

    private String describe;


}
