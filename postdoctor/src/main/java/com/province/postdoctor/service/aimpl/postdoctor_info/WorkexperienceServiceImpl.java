package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Workexperience;
import com.province.postdoctor.mapper.postdoctor_info.AwardsMapper;
import com.province.postdoctor.mapper.postdoctor_info.WorkexperienceMapper;
import com.province.postdoctor.service.postdoctor_info.WorkexperienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tykj
 * @since 2020-10-14
 */
@Service
public class WorkexperienceServiceImpl extends ServiceImpl<WorkexperienceMapper, Workexperience> implements WorkexperienceService {

    @Resource
    private WorkexperienceMapper workexperienceMapper;

    @Override
    public void deleteById(String id) {
        workexperienceMapper.deleteById(id);

    }
}
