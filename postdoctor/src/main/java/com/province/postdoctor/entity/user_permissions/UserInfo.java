package com.province.postdoctor.entity.user_permissions;

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
    public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 用户名
            */
    private String username;

            /**
            * 登录密码
            */
    private String password;

            /**
            * 用户真实姓名
            */
    private String name;

            /**
            * 用户身份证号
            */
    private String idCardNum;

    private String managementD;

            /**
            * 用户状态：0:正常状态,1：用户被锁定
            */
    private Integer sign;


}
