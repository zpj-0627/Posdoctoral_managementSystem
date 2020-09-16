package com.province.postdoctor.service.aimpl.user_permissions;

import com.province.postdoctor.entity.user_permissions.Role;
import com.province.postdoctor.mapper.user_permissions.RoleMapper;
import com.province.postdoctor.service.user_permissions.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zpj
 * @since 2020-09-15
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
