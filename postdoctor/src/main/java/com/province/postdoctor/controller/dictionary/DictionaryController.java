package com.province.postdoctor.controller.dictionary;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.result.TreeResult;
import com.province.postdoctor.service.dictionary.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-09-27
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;


    //行业目录树
    @RequestMapping("/queryAll")
    public TreeResult<Dictionary> queryAll(){
        TreeResult<Dictionary> dictionaryTreeResult = new TreeResult<>();
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("updictionaryId",10004);
        queryWrapper.select("dictionaryId","updictionaryId","name","sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        dictionaryTreeResult.setCode(0);
        dictionaryTreeResult.setData(dList);
        dictionaryTreeResult.setMsg("操作成功");
        return dictionaryTreeResult;
    }

//    //查询工作站全部一级行业
//    @RequestMapping("/queryFJob")
//    public List<Dictionary> queryFJob(){
//        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("updictionaryId",10004);
//        queryWrapper.eq("sign",0);
//        queryWrapper.orderByAsc("dictionaryId");
//        List<Dictionary> dList = dictionaryService.list(queryWrapper);
//        System.out.println(dList);
//        return dList;
//    }

    //查询工作站全部一级行业名称名称
    @RequestMapping("/queryFJob")
    public List<Dictionary> queryFJob(){
        List<Dictionary> dList = dictionaryService.f_job();
        return dList;
    }


//    //查询流动站全部所属部门名称
//    @RequestMapping("/queryDepartment")
//    public List<Dictionary> queryDepartment(){
//        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("updictionaryId",10001);
//        queryWrapper.eq("sign",0);
//        queryWrapper.orderByAsc("dictionaryId");
//        List<Dictionary> dList = dictionaryService.list(queryWrapper);
//        return dList;
//    }
    //查询流动站全部所属部门名称
    @RequestMapping("/queryDepartment")
    public List<Dictionary> queryDepartment(){
        List<Dictionary> dList = dictionaryService.department();
        System.out.println(dList);
        return dList;
    }


    //查询流动站全部一级学科名称
    @RequestMapping("/queryFsubject")
    public List<Dictionary> queryFsubject(){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryId",10003);
        queryWrapper.select("updictionaryId","name","sign");
        queryWrapper.eq("sign",0);
        queryWrapper.orderByAsc("dictionaryId");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }

//    //查询流动站全部一级学科名称
//    @RequestMapping("/queryFsubject")
//    public List<Dictionary> queryFSubject(){
//        List<Dictionary> dList = dictionaryService.f_subject();
//        return dList;
//    }


    //
    @RequestMapping("/queryAlljob")
    public List<Dictionary> queryAlljob(){

        QueryWrapper<Dictionary> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("updictionaryId",10004);
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }


//    //查询工作站全部二级行业名称名称
//    @RequestMapping("/querySjob")
//    public List<Dictionary> querySJob(String name){
//        System.out.println(name);
//        List<Dictionary> dList = dictionaryService.s_job(name);
//        System.out.println(dList);
//        return dList;
//    }
}
