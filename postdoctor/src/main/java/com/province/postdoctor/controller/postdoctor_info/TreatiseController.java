package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.province.postdoctor.entity.postdoctor_info.Treatise;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.ThesisService;
import com.province.postdoctor.service.postdoctor_info.TreatiseService;
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
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/treatise")
public class TreatiseController {

    @Resource
    private TreatiseService treatiseService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //专利信息表
    @RequestMapping("/list1")
    public PoetResult<Treatise> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Treatise> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Treatise> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("d_name","treatise_name","treatise_number","treatise_type","author_rank","publication_date");
        List<Treatise> dList = treatiseService.list(queryWrapper);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }
    //专利信息查询
    @RequestMapping("/search")
    public PoetResult<Treatise> search(Integer page, Integer limit, Treatise treatise) {
        System.out.println(treatise);
        PageHelper.startPage(page,limit);
        PoetResult<Treatise> thesisPoetResult = new PoetResult<>();
        List<Treatise> dList = treatiseService.selecttreatiseInfo(treatise);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //点击树节点搜素
    @RequestMapping("/searchById")
    public PoetResult<Treatise> selectBydId(Integer page, Integer limit, Treatise treatise) {
        PageHelper.startPage(page,limit);
        PoetResult<Treatise> postdoctorrinformationResult = new PoetResult<>();
        List<Treatise> dList = new ArrayList<>();
        QueryWrapper<Treatise> queryWrapper = new QueryWrapper<>();
        System.out.println(treatise.getDId());
        System.out.println(treatise);
        if ("110".equals(treatise.getDId())){
            queryWrapper.select("d_id","d_name","treatise_name","treatise_number","treatise_type","publication_date","author_rank");
            dList = treatiseService.list(queryWrapper);
        }else if ("01".equals(treatise.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("d_id","d_name","treatise_name","treatise_number","treatise_type","publication_date","author_rank");
            dList = treatiseService.list(queryWrapper);
        }else if ("02".equals(treatise.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("d_id","d_name","treatise_name","treatise_number","treatise_type","publication_date","author_rank");
            dList = treatiseService.list(queryWrapper);
        }else {
            dList = treatiseService.selectBydId(treatise);
        }

        System.out.println(dList);
        postdoctorrinformationResult.setCode(0);
        postdoctorrinformationResult.setMsg("");
        postdoctorrinformationResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationResult.setData(dList);
        return postdoctorrinformationResult;
    }

    //部门单位名称下拉框
    @RequestMapping("/querydName")
    public List<Treatise> querydName() {
        QueryWrapper<Treatise> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("d_name");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("d_name");
        List<Treatise> dList = treatiseService.list(queryWrapper);
        return dList;
    }
    //专利类型下拉框
    @RequestMapping("/queryType")
    public List<Treatise> queryType() {
        QueryWrapper<Treatise> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("treatise_type");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("treatise_type");
        List<Treatise> dList = treatiseService.list(queryWrapper);
        return dList;
    }

}
