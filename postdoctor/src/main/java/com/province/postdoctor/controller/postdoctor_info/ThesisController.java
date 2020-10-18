package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import com.province.postdoctor.service.postdoctor_info.ThesisService;
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
 * @since 2020-10-10
 */
@RestController
@RequestMapping("/thesis")
public class ThesisController {


    @Resource
    private ThesisService thesisService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //论文信息表
    @RequestMapping("/list1")
    public PoetResult<Thesis> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Thesis> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Thesis> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("d_name","p_id","p_name","t_ttitle","publishingtime","collection","literature");
        List<Thesis> dList = thesisService.list(queryWrapper);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //论文信息查询
    @RequestMapping("/search")
    public PoetResult<Thesis> search(Integer page, Integer limit, Thesis thesis) {
        System.out.println(thesis);
        PageHelper.startPage(page,limit);
        PoetResult<Thesis> thesisPoetResult = new PoetResult<>();
        List<Thesis> dList = thesisService.selectthesisInfo(thesis);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //部门单位名称下拉框
    @RequestMapping("/querydName")
    public List<Thesis> querydName() {
        QueryWrapper<Thesis> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("d_name");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("d_name");
        List<Thesis> dList = thesisService.list(queryWrapper);
        return dList;
    }

    //按树名字搜索
    @RequestMapping("/searchById")
    public PoetResult<Thesis> selectBydId(Integer page, Integer limit, Thesis thesis) {
        PageHelper.startPage(page,limit);
        PoetResult<Thesis> thesisPoetResult = new PoetResult<>();
        List<Thesis> dList = new ArrayList<>();
        QueryWrapper<Thesis> queryWrapper = new QueryWrapper<>();
        System.out.println(thesis.getDId());
        System.out.println(thesis);
        if ("110".equals(thesis.getDId())){
            queryWrapper.select("p_name","p_id","t_ttitle","d_name","publishingtime","collection");
            dList = thesisService.list(queryWrapper);
        }else if ("01".equals(thesis.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("p_name","p_id","t_ttitle","d_name","publishingtime","collection");
            dList = thesisService.list(queryWrapper);
        }else if ("02".equals(thesis.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("p_name","p_id","t_ttitle","d_name","publishingtime","collection");
            dList = thesisService.list(queryWrapper);
        }else {
            dList = thesisService.selectBydId(thesis);
        }

        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }



}
