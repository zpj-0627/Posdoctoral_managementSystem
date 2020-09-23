package com.province.postdoctor.service.aimpl.station_info;

import com.province.postdoctor.entity.station_info.GzzInformation;
import com.province.postdoctor.entity.station_info.poetTable;
import com.province.postdoctor.mapper.station_info.GzzInformationMapper;
import com.province.postdoctor.service.station_info.GzzInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<poetTable> selectPoetTable() {
        return gzzInformationMapper.selectPoetTable();
    }
}
