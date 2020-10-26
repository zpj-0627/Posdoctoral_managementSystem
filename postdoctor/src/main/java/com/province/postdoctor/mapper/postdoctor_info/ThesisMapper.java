package com.province.postdoctor.mapper.postdoctor_info;


import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-10
 */
public interface ThesisMapper extends BaseMapper<Thesis> {

    List<Thesis> selectthesisInfo(Thesis thesis);

    List<Thesis> selectBydId(Thesis thesis);

    void deleteById(String id);
}
