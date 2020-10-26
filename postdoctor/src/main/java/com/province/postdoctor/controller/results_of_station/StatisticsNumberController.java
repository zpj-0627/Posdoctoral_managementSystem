package com.province.postdoctor.controller.results_of_station;

import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.results_of_station.StatisticsNumber;
import com.province.postdoctor.result.NumberResult;
import com.province.postdoctor.service.results_of_station.StatisticsNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StatisticsNumber")
public class StatisticsNumberController {

   /* @Autowired
    private StatisticsNumberService statisticsNumberService;
    public NumberResult<StatisticsNumber> stationInfo(Postdoctorrinformation postdoctorrinformation){

        return true;
    }*/

}
