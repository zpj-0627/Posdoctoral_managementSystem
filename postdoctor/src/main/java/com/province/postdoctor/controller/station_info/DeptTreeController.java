package com.province.postdoctor.controller.station_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.province.postdoctor.entity.station_info.DeptTree;
import com.province.postdoctor.result.TreeResult;
import com.province.postdoctor.service.station_info.DeptTreeService;
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
 * @since 2020-09-25
 */
@RestController
@RequestMapping("/dept-tree")
public class DeptTreeController {

    @Autowired
    private DeptTreeService deptTreeService;
    //设站单位树
    @RequestMapping("/queryAll")
    public TreeResult<DeptTree> queryAll(){
        TreeResult<DeptTree> deptTreeTreeResult = new TreeResult<>();
        QueryWrapper<DeptTree> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("dId","pId","d_type","d_name");
        List<DeptTree> dlist = deptTreeService.list(queryWrapper);

        deptTreeTreeResult.setMsg("操作成功");
        deptTreeTreeResult.setData(dlist);

        return deptTreeTreeResult;
    }


}
