package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.daily_sci_act.ProjectApplication;
import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.entity.postdoctor_info.Learningexperience;
import com.province.postdoctor.entity.postdoctor_info.Workexperience;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.LearningexperienceService;
import com.province.postdoctor.service.postdoctor_info.WorkexperienceService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/workexperience")
public class WorkexperienceController {

    @Resource
    private WorkexperienceService workexperienceService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    //学习经历信息表
    @RequestMapping("/list1")
    public PoetResult<Workexperience> list1(Integer page, Integer limit,Integer pId) {
        PageHelper.startPage(page,limit);
        PoetResult<Workexperience> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Workexperience> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id",pId);
        queryWrapper.select("id","p_id","we_start_date","we_end_date","work_unit","we_position");
        List<Workexperience> dList = workexperienceService.list(queryWrapper);
        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    //查询一条信息
    @RequestMapping("/getText/{id}")
    public Workexperience getLearningexperienceById(@PathVariable int id){
        QueryWrapper<Workexperience> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return workexperienceService.getOne(queryWrapper);
    }

    //修改学习经历信息
    @RequestMapping("/update")
    public boolean update(Workexperience workexperience){
        UpdateWrapper<Workexperience> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",workexperience.getId());
        updateWrapper.set("we_start_date",workexperience.getWeStartDate());
        updateWrapper.set("we_end_date",workexperience.getWeEndDate());
        updateWrapper.set("work_unit",workexperience.getWorkUnit());
        updateWrapper.set("employment",workexperience.getEmployment());
        updateWrapper.set("nationality",workexperience.getNationality());
        updateWrapper.set("we_position",workexperience.getWePosition());
        updateWrapper.set("we_identity",workexperience.getWeIdentity());
        updateWrapper.set("we_sponsorship",workexperience.getWeSponsorship());
        return workexperienceService.update(updateWrapper);
    }

    //删除信息
    @RequestMapping("/remove/{id}")
    public Integer del(@PathVariable String id){
        QueryWrapper<Workexperience> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        workexperienceService.deleteById(id);
        boolean del=true;
        if (del){
            return 2;//删除成功
        }
        else{
            return 0;//删除失败
        }
    }
    //批量添加工作经历信息
    @RequestMapping("/addAllDoctor")
    @ResponseBody
    public boolean save( Workexperience workexperience) {
        return workexperienceService.save(workexperience);
    }
}
