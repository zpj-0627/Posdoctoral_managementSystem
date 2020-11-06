package com.province.postdoctor.service.results_of_station;


import com.baomidou.mybatisplus.extension.service.IService;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.postdoctor_info.Studyingabroadinformation;
import com.province.postdoctor.entity.results_of_station.StatisticsList;
import com.province.postdoctor.entity.results_of_station.StatisticsNumber;

import java.util.List;

public interface StatisticsNumberService extends IService<StatisticsNumber> {
    List<StatisticsList> situationOFstation(Postdoctorrinformation postdoctorrinformation);

    List<StatisticsList> list1();

    List<StatisticsList> situationOFrecruitType(Postdoctorrinformation postdoctorrinformation);

    List<StatisticsList> situationOFsubjectCategory(Postdoctorrinformation postdoctorrinformation);

    List<StatisticsList> situationOFabroadnumber(Studyingabroadinformation studyingabroadinformation);

    List<StatisticsList> situationOFabroadcountry(Studyingabroadinformation studyingabroadinformation);

    List<StatisticsList> situationOFsex(Postdoctorrinformation postdoctorrinformation);

    List<StatisticsList> situationOFoutbound(Postdoctorrinformation postdoctorrinformation);

    List<StatisticsList> situationOFoutbountunits(Postdoctorrinformation postdoctorrinformation);
}
