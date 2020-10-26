package com.province.postdoctor.service.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Fundapplication;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-15
 */
public interface FundapplicationService extends IService<Fundapplication> {

    List<Fundapplication> selectfundapplicationInfo(Fundapplication fundapplication);

    List<Fundapplication> selectBydId(Fundapplication fundapplication);

    void deleteById(String id);

}
