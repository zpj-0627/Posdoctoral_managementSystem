package com.province.postdoctor.mapper.station_info;

import com.province.postdoctor.entity.station_info.LdzInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-09-19
 */
public interface LdzInformationMapper extends BaseMapper<LdzInformation> {
    List<LdzInformation> selectByd_id(String dId);
}
