package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.province.postdoctor.entity.postdoctor_info.Learningexperience;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.LearningexperienceService;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/learningexperience")
public class LearningexperienceController {

    @Resource
    private LearningexperienceService learningexperienceService;

    @Resource
    private PostdoctorrinformationService postdoctorrinformationService;


    //学习经历信息表
    @RequestMapping("/list1")
    public PoetResult<Learningexperience> list1(Integer page, Integer limit ,Integer pId) {
      /*  System.out.println(pId);*/
        PageHelper.startPage(page,limit);
        PoetResult<Learningexperience> thesisPoetResult = new PoetResult<>();
        QueryWrapper<Learningexperience> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("lestartdate","leenddate","school","education","p_id","id");
        queryWrapper.eq("p_id",pId);
        List<Learningexperience> dList = learningexperienceService.list(queryWrapper);
       /* System.out.println(dList);*/
        thesisPoetResult.setCode(0);
        thesisPoetResult.setMsg("");
        thesisPoetResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        thesisPoetResult.setData(dList);
        return thesisPoetResult;
    }
    //查询一条信息
    @RequestMapping("/getText/{id}")
    public Learningexperience getPostdoctorrinformationById(@PathVariable int id){
        QueryWrapper<Learningexperience> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Learningexperience learningexperience= learningexperienceService.getOne(queryWrapper);
       /* System.out.println(learningexperience);*/
        return learningexperience;
    }

    /*//修改学习经历信息
    @RequestMapping("/update")
    public boolean update(Learningexperience learningexperience,Integer pId, Date lestardate, Date leenddate,String school,String education,String smName1,String smName2){
        UpdateWrapper<Learningexperience> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("p_id",learningexperience.getPId());
        updateWrapper.set("lestardate",learningexperience.getLestartdate());
        updateWrapper.set("leenddate",learningexperience.getLeenddate());
        updateWrapper.set("school",learningexperience.getSchool());
        updateWrapper.set("education",learningexperience.getEducation());
        updateWrapper.set("sm_name1",learningexperience.getSmName1());
        updateWrapper.set("sm_name2",learningexperience.getSmName2());
        return learningexperienceService.update(updateWrapper);
    }*/

    //批量添加学历信息
    @RequestMapping("/addAllDoctor")
    @ResponseBody
    public boolean addAllDoctor(@RequestBody Learningexperience learningexperience, HttpServletRequest request) {
        System.out.println(learningexperience);
        List<Learningexperience> list = learningexperience.getLearningexperienceList();
        return learningexperienceService.saveBatch(list);
    }
    @RequestMapping("/update")
    public boolean update(Learningexperience learningexperience){
      /*  System.out.println(learningexperience);*/
        UpdateWrapper<Learningexperience> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",learningexperience.getId());
        updateWrapper.set("lestartdate",learningexperience.getLestartdate());
        updateWrapper.set("leenddate",learningexperience.getLeenddate());
        updateWrapper.set("school",learningexperience.getSchool());
        updateWrapper.set("education",learningexperience.getEducation());
        updateWrapper.set("sm_name1",learningexperience.getSmName1());
        updateWrapper.set("sm_name2",learningexperience.getSmName2());
        return learningexperienceService.update(updateWrapper);
    }
}
