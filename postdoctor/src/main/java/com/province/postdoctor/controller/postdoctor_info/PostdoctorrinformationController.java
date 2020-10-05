package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    private PostdoctorrinformationService postdoctorrinformationService;

    //按条件搜素语句
    @RequestMapping("/list1")
    public PoetResult<Postdoctorrinformation> search(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctorrinformation> postdoctorrinformationTableResult = new PoetResult<>();
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dName",1);
        queryWrapper.select("pName","pId","startStation","dName","fSubject");
        List<Postdoctorrinformation> dList = postdoctorrinformationService.list(queryWrapper);
        postdoctorrinformationTableResult.setCode(0);
        postdoctorrinformationTableResult.setMsg("");
        postdoctorrinformationTableResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationTableResult.setData(dList);
        return postdoctorrinformationTableResult;
    }

    //流动站表
    @RequestMapping("/search")
    public PoetResult<Postdoctorrinformation> list1(Integer page, Integer limit, Postdoctorrinformation postdoctorrinformation) {
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctorrinformation> postdoctorrinformationResult = new PoetResult<>();
        List<Postdoctorrinformation> dList = postdoctorrinformationService.selectpostdoctorInfo(postdoctorrinformation);
        System.out.println(dList);
        postdoctorrinformationResult.setCode(0);
        postdoctorrinformationResult.setMsg("");
        postdoctorrinformationResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        postdoctorrinformationResult.setData(dList);
        return postdoctorrinformationResult;
    }


}
