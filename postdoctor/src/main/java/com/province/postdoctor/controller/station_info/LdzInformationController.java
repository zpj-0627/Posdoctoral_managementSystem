package com.province.postdoctor.controller.station_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.station_info.GzzInformation;
import com.province.postdoctor.entity.station_info.LdzInformation;
import com.province.postdoctor.entity.station_info.PoetTable;
import com.province.postdoctor.entity.station_info.UnitTree;
import com.province.postdoctor.result.Didresult;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.result.TableResult;
import com.province.postdoctor.result.TreeResult;
import com.province.postdoctor.service.station_info.GzzInformationService;
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
    @Autowired
    private GzzInformationService gzzInformationService;



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
    @RequestMapping("/queryUnitTree")
    public TreeResult<UnitTree> queryUnitTree(){
        TreeResult<UnitTree> teacherMenuTreeResult = new TreeResult<>();
        List<UnitTree> dList = gzzInformationService.selectUnitTree();
        //添加一级节点和二级节点
        UnitTree unitTree1 = new UnitTree();
        unitTree1.setDId("01");
        unitTree1.setDName("工作站");
        unitTree1.setDPid("110");
        dList.add(unitTree1);
        UnitTree unitTree2 = new UnitTree();
        unitTree2.setDId("02");
        unitTree2.setDName("流动站");
        unitTree2.setDPid("110");
        dList.add(unitTree2);
        UnitTree unitTree3 = new UnitTree();
        unitTree3.setDId("110");
        unitTree3.setDName("设站单位管理");
        unitTree3.setDPid("111");
        dList.add(unitTree3);
        teacherMenuTreeResult.setData(dList);
        teacherMenuTreeResult.setMsg("操作成功");
        return teacherMenuTreeResult;
    }

}
