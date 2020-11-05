package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Fundapplication;
import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.FundapplicationService;
import com.province.postdoctor.service.postdoctor_info.PatentService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
    //人员管理资助信息表
    @RequestMapping("/plist1")
    public PoetResult<Fundapplication> plist1(Integer page, Integer limit, Integer pId) {
        PageHelper.startPage(page,limit);
        PoetResult<Fundapplication> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Fundapplication> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id",pId);
        queryWrapper.select("id","fa_name","fund_name","approval_number","fund_grade","fa_date","approval_time");
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
    //查询一条信息
    @RequestMapping("/getText/{id}")
    public Fundapplication getFundapplicationById(@PathVariable int id){
        QueryWrapper<Fundapplication> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return fundapplicationService.getOne(queryWrapper);
    }
    //修改信息
    @RequestMapping("/update")
    public boolean update(Fundapplication patent){
        UpdateWrapper<Fundapplication> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",patent.getId());
        updateWrapper.set("fa_name",patent.getFaName());
        updateWrapper.set("fund_name",patent.getFaName());
        updateWrapper.set("approval_number",patent.getApprovalNumber());
        updateWrapper.set("fund_grade",patent.getFundGrade());
        updateWrapper.set("fa_date",patent.getFaDate());
        updateWrapper.set("approval_time",patent.getApprovalTime());
        return fundapplicationService.update(updateWrapper);
    }
    //删除信息
    @RequestMapping("/remove/{id}")
    public Integer del(@PathVariable String id){
        QueryWrapper<Fundapplication> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        fundapplicationService.deleteById(id);
        boolean del=true;
        if (del){
            return 2;//删除成功
        }
        else{
            return 0;//删除失败
        }
    }
    //批量添加博士后专利信息
    @RequestMapping("/addAllDoctor")
    @ResponseBody
    public boolean save( Fundapplication fundapplication) {
        return fundapplicationService.save(fundapplication);
    }
}
