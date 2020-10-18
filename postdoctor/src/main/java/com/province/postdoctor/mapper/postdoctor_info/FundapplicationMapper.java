package com.province.postdoctor.mapper.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Fundapplication;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.province.postdoctor.entity.postdoctor_info.Patent;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-15
 */
public interface FundapplicationMapper extends BaseMapper<Fundapplication> {

    List<Fundapplication> selectfundapplicationInfo(Fundapplication fundapplication);

    List<Fundapplication> selectBydId(Fundapplication fundapplication);

}
