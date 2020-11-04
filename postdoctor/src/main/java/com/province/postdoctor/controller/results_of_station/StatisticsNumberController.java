package com.province.postdoctor.controller.results_of_station;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.results_of_station.StatisticsList;
import com.province.postdoctor.entity.results_of_station.StatisticsNumber;
import com.province.postdoctor.result.NumberResult;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.result.StatisticsResult;
import com.province.postdoctor.result.TableResult;
import com.province.postdoctor.service.results_of_station.StatisticsNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/StatisticsNumber")
public class StatisticsNumberController {

   @Resource
    private StatisticsNumberService statisticsNumberService;

    //统计查询首页面表
    @RequestMapping("/list1")
    public List<StatisticsList> list1(){
        List<StatisticsList> dList = statisticsNumberService.list1();
        return dList;
    }

    //专利信息表
    @RequestMapping("/situationOFstation")
    public StatisticsResult<StatisticsList> situationOFstation(Postdoctorrinformation postdoctorrinformation){
        System.out.println(postdoctorrinformation);
        StatisticsResult<StatisticsList> statisticsListStatisticsResult = new StatisticsResult<>();
        List<StatisticsList> dList=statisticsNumberService.situationOFstation(postdoctorrinformation);
        statisticsListStatisticsResult.setXAxis("在站状态");
        statisticsListStatisticsResult.setYAxis("状态/人数");
        statisticsListStatisticsResult.setHtitle("在站情况统计");
        statisticsListStatisticsResult.setPtitle("在站情况比例统计");
        statisticsListStatisticsResult.setData(dList);
        return statisticsListStatisticsResult;
    }

}
