package com.province.postdoctor.service.aimpl.user_permissions;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.province.postdoctor.entity.user_permissions.User;
import com.province.postdoctor.mapper.user_permissions.UserMapper;
import com.province.postdoctor.service.user_permissions.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhangle
 * @since 2019-07-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean updatePwd(String username, String password){
        return userMapper.updatePwd(username,password);
    }
}
