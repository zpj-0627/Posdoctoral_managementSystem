package com.province.postdoctor.controller.dictionary;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.entity.dictionary.smTable;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.result.TableResult;
import com.province.postdoctor.result.TreeResult;
import com.province.postdoctor.service.dictionary.DictionaryService;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public TreeResult<Dictionary> queryAll() {
        TreeResult<Dictionary> dictionaryTreeResult = new TreeResult<>();
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("updictionaryid",10004);
        queryWrapper.select("dictionaryid", "updictionaryid", "title", "sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        dictionaryTreeResult.setCode(0);
        dictionaryTreeResult.setData(dList);
        dictionaryTreeResult.setMsg("操作成功");
        return dictionaryTreeResult;
    }

    //查询流动站全部所属部门名称
    @RequestMapping("/queryDepartment")
    public List<Dictionary> queryDepartment() {
        List<Dictionary> dList = dictionaryService.department();
        System.out.println(dList);
        return dList;
    }

    //查询流动站全部一级学科名称
    @RequestMapping("/queryFsubject")
    public List<Dictionary> queryFSubject() {
        List<Dictionary> dList = dictionaryService.f_subject();
        return dList;
    }


    //字典目录树
    @RequestMapping("/queryAlldic")
    public TreeResult<Dictionary> queryAlldic() {
        TreeResult<Dictionary> subjectmenuTreeResult = new TreeResult<>();
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("dictionaryid", "updictionaryid", "title", "sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        subjectmenuTreeResult.setData(dList);
        subjectmenuTreeResult.setMsg("操作成功");
        return subjectmenuTreeResult;
    }


    //字典table
    @RequestMapping("/list1")
    public TableResult<smTable> list1(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TableResult<smTable> dictionaryTableResult = new TableResult<>();
        List<smTable> dList = dictionaryService.selectDicTable();
        dictionaryTableResult.setCount(((Page) dList).getTotal());
        dictionaryTableResult.setData(dList);
        return dictionaryTableResult;
    }


    //重载字典信息table
    @RequestMapping("/list3")
    public TableResult<smTable> list3(Integer page, Integer limit, String smName) {
        PageHelper.startPage(page, limit);
        TableResult<smTable> dictionaryTableResult = new TableResult<>();
        List<smTable> dList = dictionaryService.selectDicTableByName(smName);
        dictionaryTableResult.setCount(((Page) dList).getTotal());
        dictionaryTableResult.setData(dList);
        return dictionaryTableResult;
    }

    //重载学科目录信息table
    @RequestMapping("/list2")
    public TableResult<smTable> list2(Integer page, Integer limit, String nodeId) {
        PageHelper.startPage(page, limit);
        TableResult<smTable> subjectmenuTableResult = new TableResult<>();
        List<smTable> dList = dictionaryService.selectDicTableById(nodeId);
        subjectmenuTableResult.setCount(((Page) dList).getTotal());
        subjectmenuTableResult.setData(dList);
        return subjectmenuTableResult;
    }

   /* //添加字典信息
    @RequestMapping("/add")
    public boolean save(Dictionary dictionary){
        System.out.println(dictionary);
        return dictionaryService.save(dictionary);
    }*/

    //添加字典信息
    @RequestMapping("/add")
    public boolean save(Dictionary dictionary) {
        int count=0;
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryid", dictionary.getUpdictionaryid());
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        System.out.println(dList);
        for (Dictionary dictionary1 : dList) {
            System.out.println(dictionary1);
            if (Optional.ofNullable(dictionary1.getTitle()).orElse("zpj").equals(dictionary.getTitle())) {
                count++;
                break;
            }
        }
        if (count>0){
            return false;
        }else {
            return dictionaryService.save(dictionary);
        }
    }

    //删除一条字典信息
    @RequestMapping("/del/{id}")
    public Integer del(@PathVariable String id){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("dictionaryid",id).eq("sign",0);
        int count = dictionaryService.count(queryWrapper);
        if (count > 1){
            return 1;//此节点有子节点不能删除
        }
        Dictionary dictionary = new Dictionary();
        dictionary.setSign(1);
        UpdateWrapper<Dictionary> dictionaryUpdateWrapper = new UpdateWrapper<>();
        dictionaryUpdateWrapper.eq("dictionaryid",id);
        boolean update = dictionaryService.update(dictionary,dictionaryUpdateWrapper);
        if (update){
            return 2;//删除成功
        }
        else{
            return 0;//删除失败
        }
    }

    //查询一条学科信息
    @RequestMapping("/getText/{id}")
    public Dictionary getDictionaryById(@PathVariable int id){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dictionaryid",id);
        return dictionaryService.getOne(queryWrapper);
    }




    //修改字典信息
    @RequestMapping("/update")
    public boolean update(String smId,String smName,String smRemark){
        UpdateWrapper<Dictionary> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("dictionaryid",smId);
        updateWrapper.set("title",smName);
        updateWrapper.set("remark",smRemark);
        return dictionaryService.update(updateWrapper);
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
        queryWrapper.eq("updictionaryid",10003);
        queryWrapper.select("dictionaryId","updictionaryid","title","sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }
    //在站状态列表
    @RequestMapping("/querystatus")
    public List<Dictionary> querystatus(){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryid",10009);
        queryWrapper.select("dictionaryid","updictionaryid","title","sign");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }
    //文献类型下拉框
    @RequestMapping("/queryLiterature")
    public List<Dictionary> queryLiterature() {
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryid", 10101);
        queryWrapper.eq("sign", 0);
        queryWrapper.select("title");
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }

    //收录情况下拉框
    @RequestMapping("/queryCollection")
    public List<Dictionary> queryCollection() {
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("updictionaryid", 10102);
        queryWrapper.select( "title");
        queryWrapper.eq("sign", 0);
        List<Dictionary> dList = dictionaryService.list(queryWrapper);
        return dList;
    }


}
