package com.province.postdoctor.controller.station_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.station_info.GzzInformation;
import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.entity.station_info.PoetTable;
import com.province.postdoctor.result.Didresult;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.station_info.GzzInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tykj
 * @since 2020-09-19
 */
@RestController
@RequestMapping("/gzz-information")
public class GzzInformationController {


    @Autowired
    private GzzInformationService gzzInformationService;

    //按条件搜素语句
    @RequestMapping("/search")
    public PoetResult<PoetTable> search(Integer page, Integer limit,  PoetTable poetTable) {
        PageHelper.startPage(page,limit);
        System.out.println(poetTable);
        PoetResult<PoetTable> szdwTableResult = new PoetResult<>();
        List<PoetTable> dList = gzzInformationService.selectPoetTable(poetTable);
        System.out.println(dList);
        szdwTableResult.setCode(0);
        szdwTableResult.setMsg("");
        szdwTableResult.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        szdwTableResult.setData(dList);
        return szdwTableResult;
    }

    //流动站表
    @RequestMapping("/list1")
    public PoetResult<PoetTable> list1(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PoetResult<PoetTable> szdwTableResult1 = new PoetResult<>();
        List<PoetTable> dList = gzzInformationService.selectPoetTableByType();
        System.out.println(dList);
        szdwTableResult1.setCode(0);
        szdwTableResult1.setMsg("");
        szdwTableResult1.setCount(((Page)dList).getTotal());//((Page)dList).getTotal()
        szdwTableResult1.setData(dList);
        return szdwTableResult1;
    }

    //点击工作站树节点展示信息
    @RequestMapping("/list2")
    public Didresult<GzzInformation> list2(String dId) {
        Didresult<GzzInformation> didresult = new Didresult<>();
        List<GzzInformation> dList=gzzInformationService.selectByd_id_g(dId);
        didresult.setStatus(0);
        didresult.setData(dList);
        System.out.println(dList);
        return didresult;
    }

}
