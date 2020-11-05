package com.province.postdoctor.controller.results_of_station;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.results_of_station.StatisticsList;
import com.province.postdoctor.result.StatisticsResult;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import com.province.postdoctor.service.results_of_station.StatisticsNumberService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/StatisticsNumber")
public class StatisticsNumberController {

   @Resource
    private StatisticsNumberService statisticsNumberService;
    @Resource
    private PostdoctorrinformationService postdoctorrinformationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //统计查询首页面表
    @RequestMapping("/list1")
    public List<StatisticsList> list1(){
        List<StatisticsList> dList = statisticsNumberService.list1();
        return dList;
    }

    //进站人数统计
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

    //招收类型统计
    @RequestMapping("/situationOFrecruitType")
    public StatisticsResult<StatisticsList> situationOFrecruitType(Postdoctorrinformation postdoctorrinformation){
        System.out.println(postdoctorrinformation);
        StatisticsResult<StatisticsList> statisticsListStatisticsResult = new StatisticsResult<>();
        List<StatisticsList> dList=statisticsNumberService.situationOFrecruitType(postdoctorrinformation);
        statisticsListStatisticsResult.setXAxis("招收类型");
        statisticsListStatisticsResult.setYAxis("类型/人数");
        statisticsListStatisticsResult.setHtitle("博士后招收类型统计");
        statisticsListStatisticsResult.setPtitle("博士后招收各类型比例统计");
        statisticsListStatisticsResult.setData(dList);
        return statisticsListStatisticsResult;
    }

    //学科领域统计
    @RequestMapping("/situationOFsubjectArea")
    public StatisticsResult<StatisticsList> situationOFsubjectArea(Postdoctorrinformation postdoctorrinformation) {
        System.out.println(postdoctorrinformation);
        StatisticsResult<StatisticsList> statisticsListStatisticsResult = new StatisticsResult<>();
        QueryWrapper<Postdoctorrinformation> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.like("subject_area_id", "10008001");
        QueryWrapper<Postdoctorrinformation> queryWrapper2 = new QueryWrapper<>();
        queryWrapper1.like("subject_area_id", "10008002");
        List<Postdoctorrinformation> dList1 = postdoctorrinformationService.list(queryWrapper1);
        List<Postdoctorrinformation> dList2 = postdoctorrinformationService.list(queryWrapper2);
        int naturalArea=dList1.size();
        int SocietyArea=dList2.size();
        StatisticsList statisticsList1 = new StatisticsList();
        StatisticsList statisticsList2 = new StatisticsList();
        statisticsList1.setName("自然科学");
        statisticsList1.setValue(naturalArea);
        statisticsList2.setName("社会科学");
        statisticsList2.setValue(SocietyArea);
        List<StatisticsList> dList= new ArrayList<>();
        dList.add(statisticsList1);
        dList.add(statisticsList2);
        statisticsListStatisticsResult.setXAxis("学科领域");
        statisticsListStatisticsResult.setYAxis("学科领域/人数");
        statisticsListStatisticsResult.setHtitle("博士后学科领域统计");
        statisticsListStatisticsResult.setPtitle("博士后各学科领域比例统计");
        statisticsListStatisticsResult.setData(dList);
        return statisticsListStatisticsResult;
    }

}
