package com.province.postdoctor.controller.station_info;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.station_info.poetTable;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.station_info.GzzInformationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PoetResult<poetTable> search(Integer page, Integer limit, String dName) {
        PageHelper.startPage(page,limit);
        PoetResult<poetTable> szdwTableResult = new PoetResult<>();
        QueryWrapper<poetTable> queryWrapper = new QueryWrapper<>();
        if (dName.equals("")){

        }else {
            queryWrapper.like("dName",dName);
        }
        List<poetTable> dList = gzzInformationService.list(queryWrapper);
        szdwTableResult.setCode(0);
        szdwTableResult.setMsg("");
        szdwTableResult.setCount(((Page)dList).getTotal());
        szdwTableResult.setData(dList);
        return szdwTableResult;
    }

}
