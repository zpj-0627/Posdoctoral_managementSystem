package com.province.postdoctor.entity.user_permissions;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
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
* @author zpj
* @since 2020-09-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("sys_permission")
    public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 父编号,本权限可能是该父编号权限的子权限
            */
    private Integer parentId;

            /**
            * 父编号列表
            */
    private String parentIds;

            /**
            * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
            */
    private String permission;

            /**
            * 资源类型，[menu|button]
            */
    private String resourceType;

            /**
            * 资源路径 如：/userinfo/list
            */
    private String url;

            /**
            * 权限名称
            */
    private String name;

            /**
            * 是否可用0可用  1不可用
            */
    private Integer sign;


}
