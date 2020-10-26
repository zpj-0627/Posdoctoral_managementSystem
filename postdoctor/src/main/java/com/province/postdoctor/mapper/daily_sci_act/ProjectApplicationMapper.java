package com.province.postdoctor.mapper.daily_sci_act;

import com.province.postdoctor.entity.daily_sci_act.ProjectApplication;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.sql.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-22
 */
public interface ProjectApplicationMapper extends BaseMapper<ProjectApplication> {

    List<ProjectApplication> selectprojectInfo(ProjectApplication projectApplication);

}
