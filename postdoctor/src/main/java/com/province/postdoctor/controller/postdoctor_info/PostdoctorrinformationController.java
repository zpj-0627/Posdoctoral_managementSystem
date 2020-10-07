package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
        queryWrapper.eq("d_type",1);
        queryWrapper.select("p_name","p_id","start_station","d_name","f_subject");
        List<Postdoctorrinformation> dList = postdoctorrinformationService.list(queryWrapper);
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
        System.out.println(postdoctorrinformationResult);
        List<Postdoctorrinformation> dList = postdoctorrinformationService.selectpostdoctorInfo(postdoctorrinformation);
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
        List<Postdoctorrinformation> dList = postdoctorrinformationService.selectBydId(postdoctorrinformation);
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

}
