package com.province.postdoctor.controller.postdoctor_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.entity.postdoctor_info.*;
import com.province.postdoctor.result.Didresult;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.*;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.Number;
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

    @Resource
    private PhdinformationService phdinformationService;

    @Resource
    private LearningexperienceService learningexperienceService;

    @Resource
    private StudyingabroadinformationService studyingabroadinformationService;

    @Resource
    private WorkexperienceService workexperienceService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //人员信息管理表
    @RequestMapping("/list1")
    public PoetResult<Postdoctorrinformation> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<Postdoctorrinformation> postdoctorrinformationTableResult = new PoetResult<>();
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("p_name","p_id","start_station","d_name","f_subject");
        List<Postdoctorrinformation> dList = postdoctorrinformationService.list(queryWrapper);
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
        queryWrapper.select("d_id,d_name");
        queryWrapper.eq("sign", 0);
        queryWrapper.orderByDesc("d_id,d_name");
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


    //查询一条信息
    @RequestMapping("/getText/{id}")
    public Postdoctorrinformation getPostdoctorrinformationById(@PathVariable int id){
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("P_id",id);
        Postdoctorrinformation postdoctorrinformation= postdoctorrinformationService.getOne(queryWrapper);
        System.out.println(postdoctorrinformation);
        return postdoctorrinformation;
    }

    @RequestMapping("/getAchievements/{id}")
    public Didresult<PostdoctoralInfoNumber> getAchievementsById(@PathVariable int id){
        System.out.println(id);
        QueryWrapper<Postdoctorrinformation> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<Phdinformation> queryWrapper2 = new QueryWrapper<>();
        QueryWrapper<Learningexperience> queryWrapper3 = new QueryWrapper<>();
        QueryWrapper<Workexperience> queryWrapper4 = new QueryWrapper<>();
        QueryWrapper<Studyingabroadinformation> queryWrapper5 = new QueryWrapper<>();
        int a=0,b=0,c=0,d=0,e=0;
        queryWrapper1.eq("P_id",id);
        queryWrapper2.eq("P_id",id);
        queryWrapper3.eq("P_id",id);
        queryWrapper4.eq("P_id",id);
        queryWrapper5.eq("P_id",id);
        List<Postdoctorrinformation> dList1=postdoctorrinformationService.list(queryWrapper1);
        List<Phdinformation> dList2=phdinformationService.list(queryWrapper2);
        List<Learningexperience> dList3 = learningexperienceService.list(queryWrapper3);
        List<Workexperience> dList4=workexperienceService.list(queryWrapper4);
        List<Studyingabroadinformation> dList5=studyingabroadinformationService.list(queryWrapper5);
        PostdoctoralInfoNumber postdoctoralInfoNumber=new PostdoctoralInfoNumber();
        for (Postdoctorrinformation postdoctorrinformation : dList1) {
            if (Optional.ofNullable(postdoctorrinformation.getPId()).orElse(123).equals(id)) {
                a++;
            }
            postdoctoralInfoNumber.setBasicInfoNumber(a);
        }
        for (Phdinformation phdinformation : dList2) {
            if (Optional.ofNullable(phdinformation.getPId()).orElse(123).equals(id)) {
                b++;
            }
            postdoctoralInfoNumber.setPhdSituationNumber(b);
        }
        for (Learningexperience learningexperience : dList3) {
            if (Optional.ofNullable(learningexperience.getPId()).orElse(123).equals(id)) {
                c++;
            }
            postdoctoralInfoNumber.setLearningExpNumber(c);
        }
        for (Workexperience workexperience : dList4) {
            if (Optional.ofNullable(workexperience.getPId()).orElse(123).equals(id)) {
                d++;
            }
            postdoctoralInfoNumber.setWorkExpNumber(d);
        }
        for (Studyingabroadinformation studyingabroadinformation : dList5) {
            if (Optional.ofNullable(studyingabroadinformation.getPId()).orElse(123).equals(id)) {
                e++;
            }
            postdoctoralInfoNumber.setStudyAbroadNumber(e);
        }
        List<PostdoctoralInfoNumber> postdoctoralInfoNumbers=new ArrayList<>();
        System.out.println(postdoctoralInfoNumber);
        postdoctoralInfoNumbers.add(postdoctoralInfoNumber);
        Didresult<PostdoctoralInfoNumber> postdoctoralInfoNumberDidresult=new Didresult<>();
        postdoctoralInfoNumberDidresult.setStatus(0);
        postdoctoralInfoNumberDidresult.setData(postdoctoralInfoNumbers);
        System.out.println(postdoctoralInfoNumberDidresult);
        return  postdoctoralInfoNumberDidresult;
    }
    @RequestMapping("/update")
    public boolean update(Postdoctorrinformation postdoctorrinformation){
        System.out.println(postdoctorrinformation);
        UpdateWrapper<Postdoctorrinformation> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("p_id",postdoctorrinformation.getPId());
        updateWrapper.set("p_name",postdoctorrinformation.getPName());
        updateWrapper.set("p_sex",postdoctorrinformation.getPSex());
        updateWrapper.set("p_b_date",postdoctorrinformation.getPBDate());
        updateWrapper.set("p_nation",postdoctorrinformation.getPNation());
        updateWrapper.set("p_marriage",postdoctorrinformation.getPMarriage());
        updateWrapper.set("p_nationality",postdoctorrinformation.getPNationality());
        updateWrapper.set("p_papers",postdoctorrinformation.getPPapers());
        updateWrapper.set("p_id_number",postdoctorrinformation.getPIdNumber());
        updateWrapper.set("p_p_status",postdoctorrinformation.getPPStatus());
        updateWrapper.set("p_jp_date",postdoctorrinformation.getPJpDate());
        updateWrapper.set("p_p_title",postdoctorrinformation.getPPTitle());
        updateWrapper.set("p_c_number",postdoctorrinformation.getPCNumber());
        updateWrapper.set("d_name",postdoctorrinformation.getDName());
        updateWrapper.set("p_unit_address",postdoctorrinformation.getPUnitAddress());
        updateWrapper.set("p_p_number",postdoctorrinformation.getPPNumber());
        updateWrapper.set("p_email",postdoctorrinformation.getPEmail());
        updateWrapper.set("p_b_city",postdoctorrinformation.getPBCity());
        updateWrapper.set("p_chr_city",postdoctorrinformation.getPChrCity());
        updateWrapper.set("p_native_place",postdoctorrinformation.getPNativePlace());
        updateWrapper.set("p_pcd_address",postdoctorrinformation.getPPcdAddress());
        updateWrapper.set("p_p_station",postdoctorrinformation.getPPStation());
        updateWrapper.set("p_pr_address",postdoctorrinformation.getPPrAddress());
        updateWrapper.set("p_m_address",postdoctorrinformation.getPMAddress());
        return postdoctorrinformationService.update(updateWrapper);
    }

}
