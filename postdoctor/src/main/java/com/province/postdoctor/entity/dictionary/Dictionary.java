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

    /*
    * 字典子id
    */
    @JsonProperty("id")
    private String dictionaryId;

    /*
     * 字典名字
     */
    @JsonProperty("title")
    private String title;

    /*
     * 字典父id
     */
    @JsonProperty("parentId")
    private String updictionaryId;

    /*
     * 删除标志
     */
    private Integer sign;

    /*
     * 描述
     */
    private String describe;


}
