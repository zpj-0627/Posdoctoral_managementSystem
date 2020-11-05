package com.province.postdoctor.controller.station_info;


import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.daily_sci_act.NameObject;
import com.province.postdoctor.entity.station_info.GzzInformation;
import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.entity.station_info.PoetTable;
import com.province.postdoctor.result.Didresult;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.station_info.GzzInformationService;
import com.province.postdoctor.service.station_info.LdzInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private LdzInformationService ldzInformationService;

    //按条件搜素语句
    @RequestMapping("/search")
    public PoetResult<PoetTable> search(Integer page, Integer limit, PoetTable poetTable) {
        PageHelper.startPage(page, limit);
        System.out.println(poetTable);
        PoetResult<PoetTable> szdwTableResult = new PoetResult<>();
        List<PoetTable> dList = gzzInformationService.selectPoetTable(poetTable);
        System.out.println(dList);
        szdwTableResult.setCode(0);
        szdwTableResult.setMsg("");
        szdwTableResult.setCount(((Page) dList).getTotal());//((Page)dList).getTotal()
        szdwTableResult.setData(dList);
        return szdwTableResult;
    }

    //流动站表
    @RequestMapping("/list1")
    public PoetResult<PoetTable> list1(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        PoetResult<PoetTable> szdwTableResult1 = new PoetResult<>();
        List<PoetTable> dList = gzzInformationService.selectPoetTableByType();
        System.out.println(dList);
        szdwTableResult1.setCode(0);
        szdwTableResult1.setMsg("");
        szdwTableResult1.setCount(((Page) dList).getTotal());//((Page)dList).getTotal()
        szdwTableResult1.setData(dList);
        return szdwTableResult1;
    }

    //点击工作站树节点展示信息
    @RequestMapping("/list2")
    public Didresult<GzzInformation> list2(String dId) {
        Didresult<GzzInformation> didresult = new Didresult<>();
        List<GzzInformation> dList = gzzInformationService.selectByd_id_g(dId);
        didresult.setStatus(0);
        didresult.setData(dList);
        System.out.println(dList);
        return didresult;
    }

    @RequestMapping("selectdNameInfo")
    public List selectdName() {
        List<GzzInformation> dList1 = gzzInformationService.list();
        List<LdzInformation> dList2 = ldzInformationService.list();
        List dList = new ArrayList<>();
        for (GzzInformation gzzInformation : dList1) {
           dList.add(gzzInformation);
        }for (LdzInformation ldzInformation : dList2) {
                dList.add(ldzInformation);
        }
        System.out.println(dList);
        return dList;
    }

    @RequestMapping("/getText/{id}")
    public NameObject list3(@PathVariable String id) {
        System.out.println(id);
        List<GzzInformation> dList1 = gzzInformationService.list();
        List<LdzInformation> dList2 = ldzInformationService.list();
        NameObject nameObject=new NameObject();
        for (GzzInformation gzzInformation : dList1) {
            if (Optional.ofNullable(gzzInformation.getDName()).orElse("123").equals(id)) {
                nameObject.setDid(gzzInformation.getDId());
                nameObject.setDname(gzzInformation.getDName());
                nameObject.setDtype(gzzInformation.getDType());
            }
        }
        for (LdzInformation ldzInformation : dList2) {
            if (Optional.ofNullable(ldzInformation.getDName()).orElse("123").equals(id)) {
                nameObject.setDid(ldzInformation.getDId());
                nameObject.setDname(ldzInformation.getDName());
                nameObject.setDtype(ldzInformation.getDType());
            }
        }
        System.out.println(nameObject);
        return nameObject;
    }
}
