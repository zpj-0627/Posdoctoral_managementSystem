package com.province.postdoctor.service.station_info;

import com.province.postdoctor.entity.station_info.GzzInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.province.postdoctor.entity.station_info.poetTable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-09-19
 */
public interface GzzInformationService extends IService<GzzInformation> {

    List<poetTable> selectPoetTableByName(String dName);
}
