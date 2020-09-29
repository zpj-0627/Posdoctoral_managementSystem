package com.province.postdoctor.entity.station_info;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
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
* @since 2020-09-25
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("dept_tree")
    public class DeptTree implements Serializable {

    private static final long serialVersionUID = 1L;
//
//            @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
@JsonProperty("id")
    private String dId;
@JsonProperty("parentId")
    private String pId;

    private String dType;
@JsonProperty("title")
    private String dName;


}
