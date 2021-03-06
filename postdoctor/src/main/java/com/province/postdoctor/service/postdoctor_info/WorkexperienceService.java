package com.province.postdoctor.service.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Workexperience;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-14
 */
public interface WorkexperienceService extends IService<Workexperience> {

    void deleteById(String id);

}
