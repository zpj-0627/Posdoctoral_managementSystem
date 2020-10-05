package com.province.postdoctor.mapper.postdoctor_info;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-05
 */
public interface PostdoctorrinformationMapper extends BaseMapper<Postdoctorrinformation> {

    List<Postdoctorrinformation> selectpostdoctorInfo(Postdoctorrinformation postdoctorrinformation);
}
