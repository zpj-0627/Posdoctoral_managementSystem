package com.province.postdoctor.service.aimpl.station_info;

import com.province.postdoctor.entity.station_info.GzzInformation;
import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.entity.station_info.PoetTable;
import com.province.postdoctor.mapper.station_info.GzzInformationMapper;
import com.province.postdoctor.service.station_info.GzzInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tykj
 * @since 2020-09-19
 */
@Service
public class GzzInformationServiceImpl extends ServiceImpl<GzzInformationMapper, GzzInformation> implements GzzInformationService {


    @Resource
    private GzzInformationMapper gzzInformationMapper;

    @Override
    public List<PoetTable> selectPoetTable(PoetTable poetTable) {
        return gzzInformationMapper.selectPoetTable(poetTable);
    }

    @Override
    public List<PoetTable> selectPoetTableByType() {
        return gzzInformationMapper.selectPoetTableByType();
    }

    @Override
    public List<GzzInformation> selectByd_id_g(String dId) {
        return gzzInformationMapper.selectByd_id_g(dId);
    }
}
