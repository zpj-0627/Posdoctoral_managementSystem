package com.province.postdoctor.mapper.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-13
 */
public interface PatentMapper extends BaseMapper<Patent> {

    List<Patent> selectpatentInfo(Patent patent);

    List<Patent> selectBydId(Patent patent);

    void deleteById(String id);

    void saveE(Patent patent);

}
