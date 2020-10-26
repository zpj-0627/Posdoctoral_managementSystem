package com.province.postdoctor.service.daily_sci_act;

import com.province.postdoctor.entity.daily_sci_act.ProjectApplication;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-22
 */
public interface ProjectApplicationService extends IService<ProjectApplication> {

    List<ProjectApplication> selectprojectInfo(ProjectApplication projectApplication);

}
