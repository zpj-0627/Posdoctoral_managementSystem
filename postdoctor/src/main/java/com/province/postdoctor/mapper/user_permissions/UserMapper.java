package com.province.postdoctor.mapper.user_permissions;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.province.postdoctor.entity.user_permissions.User;


/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zhangle
 * @since 2019-07-20
 */
public interface UserMapper extends BaseMapper<User> {
    boolean updatePwd(String username, String password);

}
