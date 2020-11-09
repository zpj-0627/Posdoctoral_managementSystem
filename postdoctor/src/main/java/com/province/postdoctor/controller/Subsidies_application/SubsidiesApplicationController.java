package com.province.postdoctor.controller.Subsidies_application;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.Subsidies_application.SubsidiesApplication;
import com.province.postdoctor.entity.daily_sci_act.ProjectApplication;
import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.entity.station_info.LdzName;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.Subsidies_application.SubsidiesApplicationService;
import com.province.postdoctor.service.station_info.LdzInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.naming.ldap.LdapName;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-11-07
 */
@RestController
@RequestMapping("/subsidies-application")
public class SubsidiesApplicationController {
    @Resource
    private SubsidiesApplicationService subsidiesApplicationService;

    @Autowired
    private LdzInformationService ldzInformationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //奖励信息表
    @RequestMapping("/list1")
    public PoetResult<SubsidiesApplication> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<SubsidiesApplication> subsidiesApplicationPoetResult = new PoetResult<>();
        QueryWrapper<SubsidiesApplication> queryWrapper = new QueryWrapper<>();
        List<SubsidiesApplication> dList = subsidiesApplicationService.list(queryWrapper);
        System.out.println(dList);
        subsidiesApplicationPoetResult.setCode(0);
        subsidiesApplicationPoetResult.setMsg("");
        subsidiesApplicationPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        subsidiesApplicationPoetResult.setData(dList);
        return subsidiesApplicationPoetResult;
    }

    //获取上回账户信息
    @RequestMapping("/list2")
    public Object list2() {
        List<SubsidiesApplication> dlist = subsidiesApplicationService.list();
        Object object = dlist.get(dlist.size()-1);
        System.out.println(dlist.get(dlist.size()-1));
        return object;
    }

    //查询一条信息
    @RequestMapping("/getLdzInformationById")
    public List<LdzName> getLdzInformationById(){
        QueryWrapper<LdzInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("d_id","4");
        LdzInformation ldzInformation = ldzInformationService.getOne(queryWrapper);
        String a1 = ldzInformation.getFSubject();
        String[] a2 = a1.split(",");
        System.out.println(Arrays.toString(a2));
        LdzName ldzNames = new LdzName();
        List<LdzName> dList1 = new ArrayList<>();
        for (String strings :a2){
            ldzNames.setName(strings);
            dList1.add(ldzNames);
        }
        return dList1;
    }



}
