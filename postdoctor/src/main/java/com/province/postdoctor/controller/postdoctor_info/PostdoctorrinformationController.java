package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2020-10-05
 */
@RestController
@RequestMapping("/postdoctorrinformation")
public class PostdoctorrinformationController {

    @Resource
    private PostdoctorrinformationService postdoctorrinformationService;

    //人员信息管理表
    @RequestMapping("/list1")
    public PoetResult<Postdoctorrinformation> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctorrinformation> postdoctorrinformationTableResult = new PoetResult<>();
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("p_name","p_id","start_station","d_name","f_subject");
        List<Postdoctorrinformation> dList = postdoctorrinformationService.list(queryWrapper);
        for (Postdoctorrinformation postdoctorrinformation1 : dList) {
            Date time=postdoctorrinformation1.getStartStation();
            System.out.println(postdoctorrinformation1.getStartStation());
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
            TimeZone tz = TimeZone.getTimeZone("GMT+8");
            sdf.setTimeZone(tz);
            Date s = null;
            String da = null;
            Date strToDate = null;
            try {
                s = sdf.parse(String.valueOf(time));
                System.out.println(s);    //  Sun Oct 22 00:00:00 CST 2017
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                da = sdf.format(s);
                System.out.println(da);   //  2017-10-22
                strToDate = sdf.parse(da);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            postdoctorrinformation1.setShowtime(da);
        }
        System.out.println(dList);
        postdoctorrinformationTableResult.setCode(0);
        postdoctorrinformationTableResult.setMsg("");
        postdoctorrinformationTableResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationTableResult.setData(dList);
        return postdoctorrinformationTableResult;
    }

    //人员管理查询
    @RequestMapping("/search")
    public PoetResult<Postdoctorrinformation> search(Integer page, Integer limit, Postdoctorrinformation postdoctorrinformation) {
        System.out.println(postdoctorrinformation);
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctorrinformation> postdoctorrinformationResult = new PoetResult<>();
        List<Postdoctorrinformation> dList = postdoctorrinformationService.selectpostdoctorInfo(postdoctorrinformation);
        for (Postdoctorrinformation postdoctorrinformation2 : dList) {
            Date time=postdoctorrinformation2.getStartStation();
            System.out.println(postdoctorrinformation2.getStartStation());
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
            TimeZone tz = TimeZone.getTimeZone("GMT+8");
            sdf.setTimeZone(tz);
            Date s = null;
            String da = null;
            Date strToDate = null;
            try {
                s = sdf.parse(String.valueOf(time));
                System.out.println(s);    //  Sun Oct 22 00:00:00 CST 2017
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                da = sdf.format(s);
                System.out.println(da);   //  2017-10-22
                strToDate = sdf.parse(da);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            postdoctorrinformation2.setShowtime(da);
        }
        System.out.println(dList);
        postdoctorrinformationResult.setCode(0);
        postdoctorrinformationResult.setMsg("");
        postdoctorrinformationResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationResult.setData(dList);
        return postdoctorrinformationResult;
    }
    //按树名字搜素
    @RequestMapping("/searchById")
    public PoetResult<Postdoctorrinformation> selectBydId(Integer page, Integer limit, Postdoctorrinformation postdoctorrinformation) {
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctorrinformation> postdoctorrinformationResult = new PoetResult<>();
        List<Postdoctorrinformation> dList = new ArrayList<>();
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        System.out.println(postdoctorrinformation.getDId());
        System.out.println(postdoctorrinformation);
        if ("110".equals(postdoctorrinformation.getDId())){
            queryWrapper.select("p_name","p_id","start_station","d_name","f_subject");
            dList = postdoctorrinformationService.list(queryWrapper);
        }else if ("01".equals(postdoctorrinformation.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("p_name","p_id","start_station","d_name","f_subject");
            dList = postdoctorrinformationService.list(queryWrapper);
        }else if ("02".equals(postdoctorrinformation.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("p_name","p_id","start_station","d_name","f_subject");
            dList = postdoctorrinformationService.list(queryWrapper);
        }else {
                dList = postdoctorrinformationService.selectBydId(postdoctorrinformation);
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
    public List<Postdoctorrinformation> querydName() {
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("d_name");
        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("d_name");
        List<Postdoctorrinformation> dList = postdoctorrinformationService.list(queryWrapper);
        return dList;
    }
    //国籍下拉框
    @RequestMapping("/queryNationality")
    public List<Postdoctorrinformation> queryNationality() {
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("p_nationality");
        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("p_nationality");
        List<Postdoctorrinformation> dList = postdoctorrinformationService.list(queryWrapper);
        return dList;
    }


    //个人基本信息表
    @RequestMapping("/getText/{id}")
    public Postdoctorrinformation getDoctorById(@PathVariable int id) {
        Postdoctorrinformation postdoctorrinformation = postdoctorrinformationService.getById(id);
        return postdoctorrinformation;
    }


}
