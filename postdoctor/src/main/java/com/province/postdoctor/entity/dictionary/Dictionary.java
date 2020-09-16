package com.province.postdoctor.entity.dictionary;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableName("dictionary")
    public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("dictionaryId")
    private String dictionaryId;

    private String name;

        @TableField("updictionaryId")
    private String updictionaryId;

    private Integer sign;

    private String describe;


}
