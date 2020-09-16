package com.province.postdoctor.entity.user_permissions;

    import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableName("sys_user_role")
    public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            /**
            * 用户id
            */
    private Integer uId;

            /**
            * 角色id
            */
    private Integer roleId;


}
