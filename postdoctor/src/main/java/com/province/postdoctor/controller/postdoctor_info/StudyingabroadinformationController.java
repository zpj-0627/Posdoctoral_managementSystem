package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.province.postdoctor.entity.postdoctor_info.Phdinformation;
import com.province.postdoctor.entity.postdoctor_info.Studyingabroadinformation;
import com.province.postdoctor.service.postdoctor_info.PhdinformationService;
import com.province.postdoctor.service.postdoctor_info.StudyingabroadinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/studyingabroadinformation")
public class StudyingabroadinformationController {

    @Autowired
    private StudyingabroadinformationService studyingabroadinformationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("list")
    public List<Studyingabroadinformation> list(){
        List<Studyingabroadinformation> studyingabroadinformations=studyingabroadinformationService.list();
        return studyingabroadinformations;
    }

    //查询一条信息
    @RequestMapping("/getText/{id}")
    public Studyingabroadinformation getStudyingabroadinformationById(@PathVariable int id){
        QueryWrapper<Studyingabroadinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("P_id",id);
        Studyingabroadinformation studyingabroadinformation= studyingabroadinformationService.getOne(queryWrapper);
        /*System.out.println(studyingabroadinformation);*/
        return studyingabroadinformation;
    }

    @RequestMapping("/update")
    public boolean update(Studyingabroadinformation studyingabroadinformation){
        System.out.println(studyingabroadinformation);
        UpdateWrapper<Studyingabroadinformation> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("p_id",studyingabroadinformation.getPId());
        updateWrapper.set("studying_abroad",studyingabroadinformation.getStudyingAbroad());
        updateWrapper.set("sa_nationality",studyingabroadinformation.getSaNationality());
        updateWrapper.set("sa_id",studyingabroadinformation.getSaId());
        updateWrapper.set("sa_logoff",studyingabroadinformation.getSaLogoff());
        updateWrapper.set("sa_start_date",studyingabroadinformation.getSaStartDate());
        updateWrapper.set("sa_end_date",studyingabroadinformation.getSaEndDate());
        updateWrapper.set("sa_school",studyingabroadinformation.getSaSchool());
        return studyingabroadinformationService.update(updateWrapper);
    }


}
