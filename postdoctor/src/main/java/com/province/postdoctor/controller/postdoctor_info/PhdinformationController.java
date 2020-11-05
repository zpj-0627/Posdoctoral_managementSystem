package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.province.postdoctor.entity.postdoctor_info.Phdinformation;
import com.province.postdoctor.service.postdoctor_info.PhdinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/phdinformation")
public class PhdinformationController {

    @Autowired
    private PhdinformationService phdinformationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //查询一条信息
    @RequestMapping("/getText/{id}")
    public Phdinformation getPhdinformationById(@PathVariable int id){
        QueryWrapper<Phdinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("P_id",id);
        Phdinformation phdinformation= phdinformationService.getOne(queryWrapper);
        /*System.out.println(phdinformation);*/
        return phdinformation;
    }

    @RequestMapping("/update")
    public boolean update(Phdinformation phdinformation){
        System.out.println(phdinformation);
        UpdateWrapper<Phdinformation> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("p_id",phdinformation.getPId());
        updateWrapper.set("d_dissertation_topic",phdinformation.getDDissertationTopic());
        updateWrapper.set("d_thesis_advisor",phdinformation.getDThesisAdvisor());
        updateWrapper.set("d_degree_certificate",phdinformation.getDDegreeCertificate());
        updateWrapper.set("ddc_sign_date",phdinformation.getDdcSignDate());
        updateWrapper.set("dd_defense_date",phdinformation.getDdDefenseDate());
        updateWrapper.set("d_degree_nationality",phdinformation.getDDegreeNationality());
        updateWrapper.set("d_doctoral_unit",phdinformation.getDDoctoralUnit());
        updateWrapper.set("d_sm_name1",phdinformation.getDSmName1());
        updateWrapper.set("d_sm_name2",phdinformation.getDSmName2());
        updateWrapper.set("dd_abstract",phdinformation.getDdAbstract());
        updateWrapper.set("sr_honers",phdinformation.getSrHoners());
        return phdinformationService.update(updateWrapper);
    }



}
