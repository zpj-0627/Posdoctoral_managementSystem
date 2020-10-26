package com.province.postdoctor.service.aimpl.daily_sci_act;

import com.province.postdoctor.entity.daily_sci_act.ProjectApplication;
import com.province.postdoctor.mapper.daily_sci_act.ProjectApplicationMapper;
import com.province.postdoctor.service.daily_sci_act.ProjectApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tykj
 * @since 2020-10-22
 */
@Service
public class ProjectApplicationServiceImpl extends ServiceImpl<ProjectApplicationMapper, ProjectApplication> implements ProjectApplicationService {

    @Resource
    private ProjectApplicationMapper projectApplicationMapper;

    @Override
    public List<ProjectApplication> selectprojectInfo(ProjectApplication projectApplication) {
        return projectApplicationMapper.selectprojectInfo(projectApplication);
    }


}
