package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Fundapplication;
import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.FundapplicationService;
import com.province.postdoctor.service.postdoctor_info.PatentService;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/fundapplication")
public class FundapplicationController {

    @Resource
    private FundapplicationService fundapplicationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



    //申请基金自助情况信息表
    @RequestMapping("/list1")
    public PoetResult<Fundapplication> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Fundapplication> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Fundapplication> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("fa_name","fund_name","approval_number","fund_grade");
        List<Fundapplication> dList = fundapplicationService.list(queryWrapper);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //申请基金自助情况信息查询
    @RequestMapping("/search")
    public PoetResult<Fundapplication> search(Integer page, Integer limit, Fundapplication fundapplication) {
        System.out.println(fundapplication);
        PageHelper.startPage(page, limit);
        PoetResult<Fundapplication> thesisPoetResult = new PoetResult<>();
        List<Fundapplication> dList = fundapplicationService.selectfundapplicationInfo(fundapplication);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page) dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //点击树节点搜素
    @RequestMapping("/searchById")
    public PoetResult<Fundapplication> selectBydId(Integer page, Integer limit, Fundapplication fundapplication) {
        System.out.println(fundapplication);
        PageHelper.startPage(page,limit);
        PoetResult<Fundapplication> postdoctorrinformationResult = new PoetResult<>();
        List<Fundapplication> dList = new ArrayList<>();
        QueryWrapper<Fundapplication> queryWrapper = new QueryWrapper<>();
        System.out.println(fundapplication.getDId());
        System.out.println(fundapplication);
        if ("110".equals(fundapplication.getDId())){
            queryWrapper.select("fa_name","fund_name","approval_number","fund_grade","fa_date","approval_time");
            dList = fundapplicationService.list(queryWrapper);
        }else if ("01".equals(fundapplication.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("fa_name","fund_name","approval_number","fund_grade","fa_date","approval_time");
            dList = fundapplicationService.list(queryWrapper);
        }else if ("02".equals(fundapplication.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("fa_name","fund_name","approval_number","fund_grade","fa_date","approval_time");
            dList = fundapplicationService.list(queryWrapper);
        }else {
            dList = fundapplicationService.selectBydId(fundapplication);
        }

        System.out.println(dList);
        postdoctorrinformationResult.setCode(0);
        postdoctorrinformationResult.setMsg("");
        postdoctorrinformationResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationResult.setData(dList);
        return postdoctorrinformationResult;
    }

}
