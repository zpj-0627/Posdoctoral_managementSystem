package com.province.postdoctor.controller.daily_sci_act;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.daily_sci_act.ProjectApplication;
import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.entity.postdoctor_info.Learningexperience;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.daily_sci_act.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/project_application")
public class ProjectApplicationController {

    @Autowired
    private ProjectApplicationService projectApplicationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //项目申请表
    @RequestMapping("/list1")
    public PoetResult<ProjectApplication> list1(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<ProjectApplication> projectApplicationPoetResult = new PoetResult<>();
        List<ProjectApplication> dList = projectApplicationService.list();
        System.out.println(dList);
        projectApplicationPoetResult.setCode(0);
        projectApplicationPoetResult.setMsg("");
        projectApplicationPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        projectApplicationPoetResult.setData(dList);
        return projectApplicationPoetResult;
    }

    //人员管理查询
    @RequestMapping("/search")
    public PoetResult<ProjectApplication> search(Integer page,Integer limit,ProjectApplication projectApplication) {
        System.out.println(projectApplication);
        PageHelper.startPage(page,limit);
        PoetResult<ProjectApplication> projectApplicationPoetResult = new PoetResult<>();
        List<ProjectApplication> dList = projectApplicationService.selectprojectInfo(projectApplication);
        System.out.println(dList);
        projectApplicationPoetResult.setCode(0);
        projectApplicationPoetResult.setMsg("");
        projectApplicationPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        projectApplicationPoetResult.setData(dList);
        return projectApplicationPoetResult;
    }

    //按树名字搜索
    @RequestMapping("/searchBydId")
    public PoetResult<ProjectApplication> selectBydId(Integer page, Integer limit, ProjectApplication projectApplication) {
        System.out.println(projectApplication);
        PageHelper.startPage(page,limit);
        PoetResult<ProjectApplication> thesisPoetResult = new PoetResult<>();
        List<ProjectApplication> dList = new ArrayList<>();
        QueryWrapper<ProjectApplication> queryWrapper = new QueryWrapper<>();
        if ("110".equals(projectApplication.getDId())){
            queryWrapper.select("applicant_unit","project_name","project_type","applicant","applicant_time","situation");
            dList = projectApplicationService.list(queryWrapper);
        }else if ("01".equals(projectApplication.getDId()))
        {
            queryWrapper.eq("d_type","01");
            queryWrapper.select("d_name","project_name","project_type","applicant","applicant_time","situation");
            dList = projectApplicationService.list(queryWrapper);
        }else if ("02".equals(projectApplication.getDId())) {
            queryWrapper.eq("d_type","02");
            queryWrapper.select("d_name","project_name","project_type","applicant","applicant_time","situation");
            dList = projectApplicationService.list(queryWrapper);
        }else {
            queryWrapper.eq("d_id",projectApplication.getDId());
            queryWrapper.select("d_name","project_name","project_type","applicant","applicant_time","situation");
            dList = projectApplicationService.list(queryWrapper);
        }

        System.out.println(dList);
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }

    @RequestMapping("/update")
    public boolean update(ProjectApplication projectApplication){
        /*  System.out.println(learningexperience);*/
        UpdateWrapper<ProjectApplication> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",projectApplication.getProjectId());
        updateWrapper.set("d_name",projectApplication.getDName());
        updateWrapper.set("project_name",projectApplication.getProjectName());
        updateWrapper.set("project_type",projectApplication.getProjectType());
        updateWrapper.set("applicant",projectApplication.getApplicant());
        updateWrapper.set("applicant_time",projectApplication.getApplicantTime());
        updateWrapper.set("situation",projectApplication.getSituation());
        return projectApplicationService.update(updateWrapper);
    }
    //查询一条信息
    @RequestMapping("/getText/{id}")
    public ProjectApplication getPostdoctorrinformationById(@PathVariable int id){
        QueryWrapper<ProjectApplication> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id",id);
        ProjectApplication projectApplication= projectApplicationService.getOne(queryWrapper);
         System.out.println(projectApplication);
        return projectApplication;
    }
    //批量添加项目申请信息
    @RequestMapping("/addAllDoctor")
    public boolean save( ProjectApplication projectApplication) {
        System.out.println(projectApplication);
        return projectApplicationService.save(projectApplication);
    }

    //获取项目申请Id
    @RequestMapping("/getprojectId")
    @ResponseBody
    public Integer getprojectId() {
        return projectApplicationService.getprojectId();
    }
}
