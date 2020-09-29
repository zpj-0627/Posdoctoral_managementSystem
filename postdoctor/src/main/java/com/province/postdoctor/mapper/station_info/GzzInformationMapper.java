package com.province.postdoctor.mapper.station_info;

import com.province.postdoctor.entity.station_info.GzzInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.entity.station_info.PoetTable;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-09-19
 */
public interface GzzInformationMapper extends BaseMapper<GzzInformation> {

    List<PoetTable> selectPoetTable(PoetTable poetTable);

    List<PoetTable> selectPoetTableByType();

    List<GzzInformation> selectByd_id_g(String dId);
}
