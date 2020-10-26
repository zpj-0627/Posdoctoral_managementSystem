package com.province.postdoctor.service.aimpl.results_of_station;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.results_of_station.StatisticsNumber;
import com.province.postdoctor.mapper.results_of_station.StatisticsNumberMapper;
import com.province.postdoctor.service.results_of_station.StatisticsNumberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatisticsNumberServiceImpl extends ServiceImpl<StatisticsNumberMapper, StatisticsNumber> implements StatisticsNumberService {

    @Resource
    private StatisticsNumberMapper statisticsNumberMapper;

    @Override
    public List<StatisticsNumber> stationInfo(Postdoctorrinformation postdoctorrinformation) {
        return statisticsNumberMapper.stationInfo(postdoctorrinformation);
    }
}
