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
        queryWrapper.select("dictionaryId","updictionaryId","title","sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        dictionaryTreeResult.setCode(0);
        dictionaryTreeResult.setData(dList);
        dictionaryTreeResult.setMsg("操作成功");
        return dictionaryTreeResult;
    }

    //查询流动站全部所属部门名称
    @RequestMapping("/queryDepartment")
    public List<Dictionary> queryDepartment(){
        List<Dictionary> dList = dictionaryService.department();
        System.out.println(dList);
        return dList;
    }

    //查询流动站全部一级学科名称
    @RequestMapping("/queryFsubject")
    public List<Dictionary> queryFSubject(){
        List<Dictionary> dList = dictionaryService.f_subject();
        return dList;
    }

    //学科门类列表
    @RequestMapping("/querySubjectCategory")
    public List<Dictionary> querySubjectCategory(){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryId",10603);
        queryWrapper.select("dictionaryId","updictionaryId","title","sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }
    //一级学科列表
    @RequestMapping("/queryfSubject")
    public List<Dictionary> queryfSubject(){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryId",10003);
        queryWrapper.select("dictionaryId","updictionaryId","title","sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }
    //在站状态列表
    @RequestMapping("/querystatus")
    public List<Dictionary> querystatus(){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryId",10009);
        queryWrapper.select("dictionaryId","updictionaryId","title","sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }
}
