package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.province.postdoctor.entity.postdoctor_info.Fundapplication;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.AwardsService;
import com.province.postdoctor.service.postdoctor_info.FundapplicationService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/awards")
public class AwardsController {

    @Resource
    private AwardsService awardsService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //奖励信息表
    @RequestMapping("/list1")
    public PoetResult<Awards> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Awards> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Awards> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("project_name","awards_name","type","awards_type","awards_date","awards_grade","ranking");
        List<Awards> dList = awardsService.list(queryWrapper);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //奖励信息查询
    @RequestMapping("/search")
    public PoetResult<Awards> search(Integer page, Integer limit, Awards awards) {
        System.out.println(awards);
        PageHelper.startPage(page, limit);
        PoetResult<Awards> thesisPoetResult = new PoetResult<>();
        List<Awards> dList = awardsService.selectawardsInfo(awards);

        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page) dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //点击树节点搜素
    @RequestMapping("/searchById")
    public PoetResult<Awards> selectBydId(Integer page, Integer limit, Awards awards) {
        PageHelper.startPage(page,limit);
        PoetResult<Awards> postdoctorrinformationResult = new PoetResult<>();
        List<Awards> dList = new ArrayList<>();
        QueryWrapper<Awards> queryWrapper = new QueryWrapper<>();
        System.out.println(awards.getDId());
        System.out.println(awards);
        if ("110".equals(awards.getDId())){
            queryWrapper.select("project_name","awards_name","type","awards_type","awards_date","awards_grade","ranking");
            dList = awardsService.list(queryWrapper);
        }else if ("01".equals(awards.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("project_name","awards_name","type","awards_type","awards_date","awards_grade","ranking");
            dList = awardsService.list(queryWrapper);
        }else if ("02".equals(awards.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("project_name","awards_name","type","awards_type","awards_date","awards_grade","ranking");
            dList = awardsService.list(queryWrapper);
        }else {
            dList = awardsService.selectBydId(awards);
        }

        System.out.println(dList);
        postdoctorrinformationResult.setCode(0);
        postdoctorrinformationResult.setMsg("");
        postdoctorrinformationResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationResult.setData(dList);
        return postdoctorrinformationResult;
    }

    //成果类型下拉框
    @RequestMapping("/queryType")
    public List<Awards> queryType() {
        QueryWrapper<Awards> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("type");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("type");
        List<Awards> dList = awardsService.list(queryWrapper);
        return dList;
    }

    //获奖类别下拉框
    @RequestMapping("/queryCategories")
    public List<Awards> queryCategories() {
        QueryWrapper<Awards> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("awards_categories");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("awards_categories");
        List<Awards> dList = awardsService.list(queryWrapper);
        return dList;
    }

    //单位名称下拉框
    @RequestMapping("/querydname")
    public List<Awards> querydname() {
        QueryWrapper<Awards> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("d_name");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("d_name");
        List<Awards> dList = awardsService.list(queryWrapper);
        return dList;
    }
}
