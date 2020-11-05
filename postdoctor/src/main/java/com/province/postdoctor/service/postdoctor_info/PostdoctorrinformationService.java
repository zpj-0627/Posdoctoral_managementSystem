package com.province.postdoctor.service.postdoctor_info;

import com.baomidou.mybatisplus.extension.service.IService;
import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-05
 */
public interface PostdoctorrinformationService extends IService<Postdoctorrinformation> {

    List<Postdoctorrinformation> selectpostdoctorInfo(Postdoctorrinformation postdoctorrinformation);

    List<Postdoctorrinformation> selectBydId(Postdoctorrinformation postdoctorrinformation);

    List<Postdoctorrinformation> selectBygzzdId();

    List<Postdoctorrinformation> getById(Integer id);



}
