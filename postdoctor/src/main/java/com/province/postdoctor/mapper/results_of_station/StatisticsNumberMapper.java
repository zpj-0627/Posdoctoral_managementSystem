package com.province.postdoctor.mapper.results_of_station;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.results_of_station.StatisticsList;
import com.province.postdoctor.entity.results_of_station.StatisticsNumber;

import java.util.List;

public interface StatisticsNumberMapper extends BaseMapper<StatisticsNumber> {
    List<StatisticsList> situationOFstation(Postdoctorrinformation postdoctorrinformation);

    List<StatisticsList> list1();

    List<StatisticsList> situationOFrecruitType(Postdoctorrinformation postdoctorrinformation);
}

