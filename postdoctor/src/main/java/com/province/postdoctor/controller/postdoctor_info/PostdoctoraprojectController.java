package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.province.postdoctor.entity.postdoctor_info.Postdoctoraproject;

import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.result.TableResult;
import com.province.postdoctor.service.postdoctor_info.PostdoctoraprojectService;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/postdoctoraproject")
public class PostdoctoraprojectController {

    @Autowired
    private PostdoctoraprojectService postdoctoraprojectService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //项目信息表
    @RequestMapping("/list1")
    public PoetResult<Postdoctoraproject> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctoraproject> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Postdoctoraproject> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("project_name","department_name","project_progress","approve_time","duty");
        List<Postdoctoraproject> dList = postdoctoraprojectService.list(queryWrapper);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //项目信息查询
    @RequestMapping("/search")
    public PoetResult<Postdoctoraproject> search(Integer page, Integer limit, Postdoctoraproject postdoctoraproject) {
        System.out.println(postdoctoraproject);
        PageHelper.startPage(page, limit);
        PoetResult<Postdoctoraproject> thesisPoetResult = new PoetResult<>();
        List<Postdoctoraproject> dList = postdoctoraprojectService.selectpostdoctoraprojectInfo(postdoctoraproject);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page) dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //点击树节点搜素
    @RequestMapping("/searchById")
    public PoetResult<Postdoctoraproject> selectBydId(Integer page, Integer limit, Postdoctoraproject postdoctoraproject) {
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctoraproject> postdoctorrinformationResult = new PoetResult<>();
        List<Postdoctoraproject> dList = new ArrayList<>();
        QueryWrapper<Postdoctoraproject> queryWrapper = new QueryWrapper<>();
        System.out.println(postdoctoraproject.getDId());
        System.out.println(postdoctoraproject);
        if ("110".equals(postdoctoraproject.getDId())){
            queryWrapper.select("project_name","department_name","project_progress","approve_time","duty");
            dList = postdoctoraprojectService.list(queryWrapper);
        }else if ("01".equals(postdoctoraproject.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("project_name","department_name","project_progress","approve_time","duty");
            dList = postdoctoraprojectService.list(queryWrapper);
        }else if ("02".equals(postdoctoraproject.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("project_name","department_name","project_progress","approve_time","duty");
            dList = postdoctoraprojectService.list(queryWrapper);
        }else {
            dList = postdoctoraprojectService.selectBydId(postdoctoraproject);
        }

        System.out.println(dList);
        postdoctorrinformationResult.setCode(0);
        postdoctorrinformationResult.setMsg("");
        postdoctorrinformationResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationResult.setData(dList);
        return postdoctorrinformationResult;
    }

    //下达部门下拉框
    @RequestMapping("/queryDepartment")
    public List<Postdoctoraproject> queryDepartment() {
        QueryWrapper<Postdoctoraproject> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("department_name");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("department_name");
        List<Postdoctoraproject> dList = postdoctoraprojectService.list(queryWrapper);
        return dList;
    }

    //项目性质下拉框
    @RequestMapping("/queryprojectNature")
    public List<Postdoctoraproject> queryprojectNature() {
        QueryWrapper<Postdoctoraproject> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("project_nature");
//        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("project_nature");
        List<Postdoctoraproject> dList = postdoctoraprojectService.list(queryWrapper);
        return dList;
    }
}