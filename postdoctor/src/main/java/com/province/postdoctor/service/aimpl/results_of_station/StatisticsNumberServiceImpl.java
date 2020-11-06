package com.province.postdoctor.service.aimpl.results_of_station;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.postdoctor_info.Studyingabroadinformation;
import com.province.postdoctor.entity.results_of_station.StatisticsList;
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
    public List<StatisticsList> situationOFstation(Postdoctorrinformation postdoctorrinformation) {
        return statisticsNumberMapper.situationOFstation(postdoctorrinformation);
    }

    @Override
    public List<StatisticsList> list1() {
        return statisticsNumberMapper.list1();
    }

    @Override
    public List<StatisticsList> situationOFrecruitType(Postdoctorrinformation postdoctorrinformation) {
        return statisticsNumberMapper.situationOFrecruitType(postdoctorrinformation);
    }

    @Override
    public List<StatisticsList> situationOFsubjectCategory(Postdoctorrinformation postdoctorrinformation) {
        return statisticsNumberMapper.situationOFsubjectCategory(postdoctorrinformation);
    }

    @Override
    public List<StatisticsList> situationOFabroadnumber(Studyingabroadinformation studyingabroadinformation) {
        return statisticsNumberMapper.situationOFabroadnumber(studyingabroadinformation);
    }

    @Override
    public List<StatisticsList> situationOFabroadcountry(Studyingabroadinformation studyingabroadinformation) {
        return statisticsNumberMapper.situationOFabroadcountry(studyingabroadinformation);
    }

    @Override
    public List<StatisticsList> situationOFsex(Postdoctorrinformation postdoctorrinformation) {
        return statisticsNumberMapper.situationOFsex(postdoctorrinformation);
    }

    @Override
    public List<StatisticsList> situationOFoutbound(Postdoctorrinformation postdoctorrinformation) {
        return statisticsNumberMapper.situationOFoutbound(postdoctorrinformation);
    }

    @Override
    public List<StatisticsList> situationOFoutbountunits(Postdoctorrinformation postdoctorrinformation) {
        return statisticsNumberMapper.situationOFoutbountunits(postdoctorrinformation);
    }
}
