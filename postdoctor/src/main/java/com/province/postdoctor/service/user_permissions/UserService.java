package com.province.postdoctor.service.user_permissions;

import com.baomidou.mybatisplus.extension.service.IService;
import com.province.postdoctor.entity.user_permissions.User;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhangle
 * @since 2019-07-20
 */
public interface UserService extends IService<User> {
    boolean updatePwd(String username, String password);

}
