package com.province.postdoctor.controller.station_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.station_info.GzzInformation;
import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.entity.station_info.PoetTable;
import com.province.postdoctor.result.Didresult;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.result.TableResult;
import com.province.postdoctor.service.station_info.LdzInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/ldz-information")
public class LdzInformationController {

    @Autowired
    private LdzInformationService ldzInformationService;



    //点击流动站树节点展示信息
    @RequestMapping("/list1")
    public List<LdzInformation> list1( String dId) {
        QueryWrapper<LdzInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dId",dId);
        List<LdzInformation> dList = ldzInformationService.list(queryWrapper);
        return dList;
    }



    //点击流动站树节点展示信息
    @RequestMapping("/list2")
    public Didresult<LdzInformation> list2(String dId) {
        Didresult<LdzInformation> didresult = new Didresult<>();
        List<LdzInformation> dList=ldzInformationService.selectByd_id(dId);
        didresult.setStatus(0);
        didresult.setData(dList);
        System.out.println(dList);
        System.out.println(dId);
        return didresult;
    }
//        //点击工作站树节点展示信息
//        @RequestMapping("/list2")
//        public Didresult<LdzInformation> list2(String dId) {
//            System.out.println(dId);
//            Didresult<LdzInformation> didresult = new Didresult<>();
//            QueryWrapper<LdzInformation> queryWrapper = new QueryWrapper<>();
//            queryWrapper.eq("dId",dId);
//            List<LdzInformation> dList = ldzInformationService.list(queryWrapper);
//            didresult.setStatus(0);
//            didresult.setData(dList);
//
//            return didresult;
//        }

}
