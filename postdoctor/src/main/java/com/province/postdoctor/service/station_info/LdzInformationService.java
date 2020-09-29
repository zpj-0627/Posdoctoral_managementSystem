package com.province.postdoctor.service.station_info;

import com.province.postdoctor.entity.station_info.LdzInformation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-09-19
 */
public interface LdzInformationService extends IService<LdzInformation> {


    List<LdzInformation> selectByd_id(String dId);

}
