package com.province.postdoctor.controller.postdoctor_info;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.result.PoetResult;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Package: com.province.postdoctor.controller.postdoctor_info
 * <p>
 * Description： TODO
 * <p>
 * Author: 作者
 * <p>
 * Date: Created in 2020/10/11 15:33
 * <p>
 * Company: 公司
 * <p>
 * Copyright: Copyright (c) 2017
 * <p>
 * Version: 0.0.1
 * <p>
 * Modified By:
 */
@RestController
@RequestMapping("/BasicInfo")
public class BasicInfo {

    private PostdoctorrinformationService postdoctorrinformationService;

    //基本信息数据条数
    @RequestMapping("/number")
    public Integer basicInfonumber(Postdoctorrinformation postdoctorrinformation) {
        QueryWrapper<Postdoctorrinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", postdoctorrinformation.getPId());
        List<Postdoctorrinformation> dList = postdoctorrinformationService.list(queryWrapper);
        int number = 0;
        for (Postdoctorrinformation postdoctorrinformation1 : dList) {
            if (Optional.ofNullable(postdoctorrinformation1.getPId()).orElse(10).equals(postdoctorrinformation.getPId())) {
                number++;
            }
        }
        return number;
    }
}