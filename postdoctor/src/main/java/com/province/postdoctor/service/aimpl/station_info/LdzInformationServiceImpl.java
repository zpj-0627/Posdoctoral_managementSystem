package com.province.postdoctor.service.aimpl.station_info;

import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.mapper.station_info.LdzInformationMapper;
import com.province.postdoctor.service.station_info.LdzInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class LdzInformationServiceImpl extends ServiceImpl<LdzInformationMapper, LdzInformation> implements LdzInformationService {

    @Autowired
    private LdzInformationMapper ldzInformationMapper;


    @Override
    public List<LdzInformation> selectByd_id(String dId) {
        return ldzInformationMapper.selectByd_id(dId);
    }


}
