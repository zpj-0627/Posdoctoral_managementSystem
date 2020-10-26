package com.province.postdoctor.mapper.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.province.postdoctor.entity.postdoctor_info.Fundapplication;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-15
 */
public interface AwardsMapper extends BaseMapper<Awards> {

    List<Awards> selectawardsInfo(Awards awards);


    List<Awards> selectBydId(Awards awards);

    void deleteById(String id);

}
