package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Patent;


import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.PatentService;

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
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/patent")
public class PatentController {

    @Resource
    private PatentService patentService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    //专利信息表
    @RequestMapping("/list1")
    public PoetResult<Patent> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Patent> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Patent> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("d_name","p_id","p_name","patenter","patent_name","papplydate","ptype","opendate");
        List<Patent> dList = patentService.list(queryWrapper);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }
    //专利信息查询
    @RequestMapping("/search")
    public PoetResult<Patent> search(Integer page, Integer limit, Patent patent) {
        System.out.println(patent);
        PageHelper.startPage(page,limit);
        PoetResult<Patent> thesisPoetResult = new PoetResult<>();
        List<Patent> dList = patentService.selectpatentInfo(patent);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //点击树节点搜素
    @RequestMapping("/searchById")
    public PoetResult<Patent> selectBydId(Integer page, Integer limit, Patent patent) {
        PageHelper.startPage(page,limit);
        PoetResult<Patent> postdoctorrinformationResult = new PoetResult<>();
        List<Patent> dList = new ArrayList<>();
        QueryWrapper<Patent> queryWrapper = new QueryWrapper<>();
        System.out.println(patent.getDId());
        System.out.println(patent);
        if ("110".equals(patent.getDId())){
            queryWrapper.select("p_name","p_id","papplydate","opendate","patenter","patent_name","ptype");
            dList = patentService.list(queryWrapper);
        }else if ("01".equals(patent.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("p_name","p_id","papplydate","opendate","patenter","patent_name","ptype");
            dList = patentService.list(queryWrapper);
        }else if ("02".equals(patent.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("p_name","p_id","papplydate","opendate","patenter","patent_name","ptype");
            dList = patentService.list(queryWrapper);
        }else {
            dList = patentService.selectBydId(patent);
        }

        System.out.println(dList);
        postdoctorrinformationResult.setCode(0);
        postdoctorrinformationResult.setMsg("");
        postdoctorrinformationResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationResult.setData(dList);
        return postdoctorrinformationResult;
    }


    //专利权人下拉框
    @RequestMapping("/querytName")
    public List<Patent> querytName() {
        QueryWrapper<Patent> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("patenter");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("patenter");
        List<Patent> dList = patentService.list(queryWrapper);
        return dList;
    }

    //专利名称下拉框
    @RequestMapping("/querypName")
    public List<Patent> querypName() {
        QueryWrapper<Patent> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("patent_name");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("patent_name");
        List<Patent> dList = patentService.list(queryWrapper);
        return dList;
    }
}
